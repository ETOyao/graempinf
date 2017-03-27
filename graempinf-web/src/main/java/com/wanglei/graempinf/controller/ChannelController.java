package com.wanglei.graempinf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.EnumUtils;
import com.wanglei.graempinf.Webutils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.dto.AjaxObj;
import com.wanglei.graempinf.dto.TreeDto;
import com.wanglei.graempinf.service.IChannelService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf_core.graempinf_core.Enum.ChannelType;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;

@RequestMapping("/admin/channel")
@Controller
@AuthClass
public class ChannelController {
	static Logger log = Logger.getLogger(ChannelController.class);
	private IChannelService channelService;
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}



	/**
	 * <p>Description:一次性的获取树的数据<p>
	 * @param model
	 * @return
	 * @author WangLei 2017年2月4日
	 */
	@RequestMapping("/channels")
	public String list(Model model) {
//		model.addAttribute("treeDatas", JsonUtil.getInstance().obj2json(channelService.generateTree()));
		return "channel/list";
	}
	
	@RequestMapping("/channels/{pid}")
	public String listChild(@PathVariable Integer pid,@Param Integer refresh,Model model) {
		Channel pc = null;
		if(refresh==null) {
			model.addAttribute("refresh",0);
		} else {
			model.addAttribute("refresh",1);
		}
		if(pid==null||pid<=0) {
			pc = new Channel();
			pc.setName(Channel.ROOT_NAME);
			pc.setId(Channel.ROOT_ID);
		} else
			pc = channelService.load(pid);
		model.addAttribute("pc", pc);
		model.addAttribute("channels",channelService.listByParent(pid));
		return "channel/list_child";
	}
	
	/**
	 * <p>Description:ajax的一次性异步获取json格式的数据<p>
	 * @return
	 * @author WangLei 2017年2月4日
	 */
	@RequestMapping("/treeAll")
	public @ResponseBody List<ChannelTree> tree() {
		return channelService.generateTree();
	}
	
	/**
	 * <p>Description:异步加载每一个子节点数据<p>
	 * @param pid
	 * @return
	 * @author WangLei 2017年2月4日
	 */
	@RequestMapping(value="/treeAs",method=RequestMethod.POST)
	public @ResponseBody List<TreeDto> tree(@Param Integer pid) {
		List<TreeDto> tds = new ArrayList<TreeDto>();
		if(pid==null||pid<=0) {
			tds.add(new TreeDto(0,"网站根栏目",1));
			return tds;
		}
		List<ChannelTree> cts = channelService.generateTreeByParent(pid);
		for(ChannelTree ct:cts) {
			tds.add(new TreeDto(ct.getId(),ct.getName(),1));
		}
		return tds;
	}
	
	private void initAdd(Model model,Integer pid) {
		if(pid==null) pid = 0;
		Channel pc = null;
		if(pid==0) {
			pc = new Channel();
			pc.setId(Channel.ROOT_ID);
			pc.setName(Channel.ROOT_NAME);
		} else {
			pc = channelService.load(pid);
		}
		model.addAttribute("pc", pc);
		model.addAttribute("types", EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.GET)
	public String add(@PathVariable Integer pid,Model model) {
		initAdd(model, pid);
		model.addAttribute(new Channel());
		return "channel/add";
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.POST)
	public String add(@PathVariable Integer pid,Channel channel,BindingResult br,Model model,HttpSession session) {
		if(br.hasErrors()) {
			initAdd(model, pid);
			return "channel/add";
		}
		channelService.add(channel, pid);
		Webutils.putChannels(session, channelService);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]添加菜单！"+channel.getName());
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	@RequestMapping("/delete/{pid}/{id}")
	public String delete(@PathVariable Integer pid,@PathVariable Integer id,Model model,HttpSession session) {
		channelService.delete(id);
		Webutils.putChannels(session, channelService);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]删除菜单！");
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable Integer id,Model model) {
		Channel c = channelService.load(id);
		model.addAttribute("channel", c);
		Channel pc = null;
		if(c.getParent()==null) {
			pc = new Channel();
			pc.setId(Channel.ROOT_ID);
			pc.setName(Channel.ROOT_NAME);
		} else {
			pc = c.getParent();
		}
		model.addAttribute("pc",pc);
		model.addAttribute("types", EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
		return "channel/update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable Integer id,Channel channel,BindingResult br,Model model,HttpSession session) {
		if(br.hasErrors()) {
			model.addAttribute("types", EnumUtils.enumProp2NameMap(ChannelType.class, "name"));	
			return "channel/update";
		}
		Channel tc = channelService.load(id);
		int pid = 0;
		if(tc.getParent()!=null) pid = tc.getParent().getId();
		tc.setCustomLink(channel.getCustomLink());
		tc.setCustomLinkUrl(channel.getCustomLinkUrl());
		tc.setIsIndex(channel.getIsIndex());
		tc.setIsTopNav(channel.getIsTopNav());
		tc.setName(channel.getName());
		tc.setRecommend(channel.getRecommend());
		tc.setStatus(channel.getStatus());
		tc.setType(channel.getType());
//		tc.setNavOrder(channel.getNavOrder());
		channelService.update(tc);
		Webutils.putChannels(session, channelService);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]修改菜单！"+channel.getName());
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	@RequestMapping("/channels/updateSort")
	public @ResponseBody AjaxObj updateSort(@Param Integer[] ids,HttpSession session) {
		try {
			channelService.updateSort(ids);
//		     indexService.generateTop();
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		Webutils.putChannels(session, channelService);
		return new AjaxObj(1);
	}
}
