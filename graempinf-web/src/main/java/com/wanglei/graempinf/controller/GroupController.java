package com.wanglei.graempinf.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.graempinf.Webutils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.service.IChannelService;
import com.wanglei.graempinf.service.IGroupService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.Group;

@Controller
@RequestMapping("/admin/group")
@AuthClass
public class GroupController {
	static Logger log = Logger.getLogger(GroupController.class);
	private IGroupService groupService;
	private IUserService userService;
	private IChannelService channelService;

	
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IGroupService getGroupService() {
		return groupService;
	}

	@Inject
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@RequestMapping("/groups")
	public String list(Model model) {
		model.addAttribute("datas",groupService.findGroup());
		return "group/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Group());
		return "group/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Group group,BindingResult br) {
		if(br.hasErrors()) {
			return "group/add";
		}
		groupService.add(group);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]添加用户组！"+group.getGroupName());
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/update/{gruopUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String gruopUuid,Model model) {
		model.addAttribute(groupService.load(gruopUuid));
		return "group/update";
	}
	
	@RequestMapping(value="/update/{gruopUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String gruopUuid,@Validated Group group,BindingResult br) {
		if(br.hasErrors()) {
			return "group/update";
		}
		Group ug = groupService.load(gruopUuid);
		ug.setGroupDesc(group.getGroupDesc());
		ug.setGroupName(group.getGroupName());
		groupService.update(ug);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]修改用户组！"+group.getGroupName());
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping("/delete/{gruopUuid}")
	public String delete(@PathVariable String gruopUuid) {
		groupService.delete(gruopUuid);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]删除加用户组！");
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping("/{gruopUuid}")
	public String show(@PathVariable String  gruopUuid,Model model) {
		model.addAttribute(groupService.load(gruopUuid));
		model.addAttribute("us", userService.listGroupUsers(gruopUuid));
		return "group/show";
	}
	
	@RequestMapping("/clearUsers/{gruopUuid}")
	public String clearGroupUsers(@PathVariable String gruopUuid) {
		groupService.deleteGroupUsers(gruopUuid);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]清空用户组用户！");
		return "redirect:/admin/group/groups";
	}
	@RequestMapping("/listChannels/{gruopUuid}")
	public String listChannels(@PathVariable String gruopUuid,Model model) {
		model.addAttribute(groupService.load(gruopUuid));
		return "/group/listChannel";
	}
	
	@RequestMapping("/groupTree/{gruopUuid}")
	public @ResponseBody List<ChannelTree> groupTree(@PathVariable String gruopUuid) {
		return groupService.generateGroupChannelTree(gruopUuid);
	}
	
	@RequestMapping("/setChannels/{gruopUuid}")
	public String setChannels(@PathVariable String gruopUuid,Model model,HttpSession session) {
		Group group = groupService.load(gruopUuid);
		model.addAttribute(group);
		model.addAttribute("cids",groupService.listGroupChannelIds(gruopUuid));
		Webutils.putChannels(session, channelService);
		return "/group/setChannel";
	}
}
