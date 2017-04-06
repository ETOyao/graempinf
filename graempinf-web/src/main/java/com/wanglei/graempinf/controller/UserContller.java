package com.wanglei.graempinf.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.dto.UserDto;
import com.wanglei.graempinf.service.IChannelService;
import com.wanglei.graempinf.service.IGroupService;
import com.wanglei.graempinf.service.IRoleService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.GraempinfSessionContext;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;

@Controller
@RequestMapping("/admin/user")
@AuthClass("login")
public class UserContller {
	static Logger log = Logger.getLogger(UserContller.class);
	/**
	 * 用户service注入
	 */
	private IUserService userService;
	private IGroupService groupService;
	private IRoleService roelService;
	private IChannelService channelService;
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}
	public IGroupService getGroupService() {
		return groupService;
	}
	public IRoleService getRoelService() {
		return roelService;
	}
	@Inject
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	@Inject
	public void setRoelService(IRoleService roelService) {
		this.roelService = roelService;
	}
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/users")
	public String list(Model model){
		model.addAttribute("users",userService.findUserListByPage());
		return "user/list";
	}
	@RequestMapping("/onlineUsers")
	public String onlineUsers(Model model){
		    List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();//采用list装数据  
	       Map<String, HttpSession> onLines=GraempinfSessionContext.getOnlineUsers();    
	       Iterator<Map.Entry<String, HttpSession>> it= onLines.entrySet().iterator();  
	        while(it.hasNext()){  
	            Entry<String, HttpSession> entry=it.next();  
	            HttpSession sess=entry.getValue();//拿到单个的session对象了  
	            Map<String, Object> mm =new HashMap<String, Object>();//采用map封装一行数据，然后放在list 中去，就是一个表的数据  
	            mm.put("id", sess.getId());//获取session的id  
	            mm.put("createTime",new Date(sess.getCreationTime()));//创建的时间.传过去的是date类型我们前台进行解析，显示出来  
	            mm.put("lastAccessedTime", new Date(sess.getLastAccessedTime()));//上次访问的时间  
	            mm.put("user", sess.getAttribute("loginUser"));  
	            mm.put("ip", sess.getAttribute("ip"));  
	            //前台需要的信息补全，后台去使用  
	            list.add(mm);             
	        }  
		model.addAttribute("onlineUsers",list);
		return "user/onlineuserlist";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("userDto",new UserDto());
		this.inintAddUser(model);
		return "user/add";
	}
	/**
	 * <p>Description:初始化add<p>
	 * @param model
	 * @author WangLei 2017年1月31日
	 */
	private void inintAddUser(Model model){
		List<Role> rs = roelService.listRole();
		List <Group> gs = groupService.listGroup();
		for(Role r :rs){
			if(r.getRoleType()==RoleType.ROLE_STUDENT){
				rs.remove(r);
			}
		}
		for(int i=0;i<gs.size();i++){
			if("学生".equals(gs.get(i).getGroupName())){
				gs.remove(i);
			}
		}
		model.addAttribute("roles",rs);
		model.addAttribute("groups",gs);
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid UserDto userDto ,BindingResult br, Model model){
		if(br.hasErrors()){
			this.inintAddUser(model);
			return "user/add";
		}
		userService.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]创建用户:"+userDto.getUserName()+"");
		return "redirect:/admin/user/users ";
	}
	@RequestMapping(value="/delete/{userUuid}",method=RequestMethod.GET)
	public String delete(@PathVariable String userUuid){
		userService.delete(userUuid);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]删除用户！");
		return "redirect:/admin/user/users";
	}
	@RequestMapping(value="/updateStatus/{userUuid}",method=RequestMethod.GET)
	public String updateStatus(@PathVariable String userUuid){
		userService.updateStatus(userUuid);
		return "redirect:/admin/user/users";
	}
	@RequestMapping(value="/update/{userUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String userUuid,Model model){
		User u = userService.loadUser(userUuid);
		model.addAttribute("userDto", new UserDto(u, userService.listRoleIds(userUuid),
				userService.listGroupids(userUuid)));
		inintAddUser(model);
		return "/user/update";
	}
	@RequestMapping(value="/update/{userUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String userUuid,@Valid UserDto userDto ,BindingResult br, Model model){
		if(br.hasErrors()){
			this.inintAddUser(model);
			return "user/update";
		}
		User ou = userService.loadUser(userUuid);
		ou.setUserNickName(userDto.getUserNickName());
		ou.setUserEmail(userDto.getUserEmail());
		ou.setUserPhone(userDto.getUserPhone());
		ou.setUserStatus(userDto.getUserStatus());
		userService.update(ou, userDto.getRoleIds(), userDto.getGroupIds());
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]修改用户:"+userDto.getUserName()+"");
		return "redirect:/admin/user/users";
	}
	@RequestMapping(value="/{userUuid}",method=RequestMethod.GET)
	public String show(@PathVariable String userUuid,Model model){
		model.addAttribute(userService.loadUser(userUuid));
		model.addAttribute("gs",userService.listUserGroup(userUuid));
		model.addAttribute("rs",userService.listUserRoles(userUuid));
		return "user/show";
	}
	@RequestMapping("/showSelf")
	@AuthMethod
	public String showSelf(Model model,HttpSession session) {
		User user = (User)session.getAttribute("loginUser");
		model.addAttribute(user);
		model.addAttribute("gs",userService.listUserGroup(user.getUserUuid()));
		model.addAttribute("rs",userService.listUserRoles(user.getUserUuid()));
		return "user/show";
	}
	
	@RequestMapping(value="/updatePwd",method=RequestMethod.GET)
	@AuthMethod
	public String updatePwd(Model model,HttpSession session) {
		User u = (User)session.getAttribute("loginUser");
		model.addAttribute(u);
		return "user/updatePwd";
	}
	
	@RequestMapping(value="/updatePwd",method=RequestMethod.POST)
	@AuthMethod
	public String updatePwd(String userUuid,String oldPwd,String userPassWord) {
		userService.updatePwd(userUuid, oldPwd, userPassWord);
		log.info("用户：["+userService.getCurentLoginUser().getUserNickName()+"]修改密码！");
		return "redirect:/admin/user/showSelf";
	}
	@RequestMapping(value="/updateSelf",method=RequestMethod.GET)
	@AuthMethod
	public String updateSelf(Model model,HttpSession session) {
		User u = (User)session.getAttribute("loginUser");
		model.addAttribute(new UserDto(u));
		return "user/updateSelf";
	}
	
	@RequestMapping(value="/updateSelf",method=RequestMethod.POST)
	@AuthMethod
	public String updateSelf(@Valid UserDto userDto,BindingResult br,Model model,HttpSession session) {
		if(br.hasErrors()) {
			return "user/updateSelf";
		}
		User ou = userService.loadUser(userDto.getUserUuid());
		ou.setUserNickName(userDto.getUserNickName());
		ou.setUserPhone(userDto.getUserPhone());
		ou.setUserEmail(userDto.getUserEmail());
		userService.update(ou);
		session.setAttribute("loginUser", ou);
		return "redirect:/admin/user/showSelf";
	}
	@RequestMapping("/listChannels/{userUuid}")
	public String listChannels(@PathVariable String userUuid,Model model) {
		model.addAttribute(userService.loadUser(userUuid));
		List<Role> rs = userService.listUserRoles(userUuid);
		for(Role r:rs) {
			if(r.getRoleType()==RoleType.ROLE_ADMIN) {
				model.addAttribute("uAdmin",1);
			}
		}
		return "/user/listChannel";
	}
	
	@RequestMapping("/userTree/{userUuid}")
	public @ResponseBody List<ChannelTree> groupTree(@PathVariable String userUuid,@RequestParam Integer isAdmin) {
		if(isAdmin!=null&&isAdmin==1) {
			return channelService.generateTree();
		}
		return groupService.generateUserChannelTree(userUuid);
	}
}
