package com.wanglei.graempinf.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.Captcha;
import com.wanglei.basic.util.JsonUtil;
import com.wanglei.graempinf.service.IChannelService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.GraempinfSessionContext;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;

@Controller
public class LoginController {
	static Logger log = Logger.getLogger(LoginController.class);
	private IChannelService channelService;
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
	
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("error", "");
		return "admin/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String userName,String userPassWord,Model model,HttpSession session) {
		User loginUser =null;
		try {
			loginUser = userService.login(userName, userPassWord);
		} catch (Exception e) {
			log.error("-----------------------------用户登录失败："+e.getMessage()+"-----------");
			model.addAttribute("error", e.getMessage()+"!");
			return "admin/login";
		}
		session.setAttribute("loginUser", loginUser);
		List<Role> rs = userService.listUserRoles(loginUser.getUserUuid());
		boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
		boolean isTeacher = isRole(rs,RoleType.ROLE_TEACHTER);
		boolean isStu = isRole(rs,RoleType.ROLE_STUDENT);
		session.setAttribute("isAdmin", isAdmin);
		session.setAttribute("isTeacher", isTeacher);
		session.setAttribute("isStu", isStu);
		session.setAttribute("useruuid", loginUser.getUserUuid());
		String userUuid = loginUser.getUserUuid();
		ServletContext application = session.getServletContext();
		application.setAttribute("channels", channelService.listTopNavChannel(userUuid));
		if(!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isStudent", isRole(rs,RoleType.ROLE_STUDENT));
		      session.setAttribute("isTeacher", isRole(rs,RoleType.ROLE_TEACHTER));
		}
		log.info("---------------------用户["+loginUser.getUserNickName()+"]登录成功！"+"-----------");
		session.removeAttribute("cc");
		GraempinfSessionContext.addSessoin(session);
		return "redirect:/admin";
	}
	@RequestMapping(value="/validateCheckcode",method=RequestMethod.POST)
	@ResponseBody
	public String valiteCheckcode(String checkcode,HttpSession session){
		String istrue = "false";
		String cc = (String)session.getAttribute("cc");
		if(checkcode.equals(cc)) {
			istrue = "true";
		}
		return istrue;
	}
	@RequestMapping(value="/getCount",produces = "application/text; charset=utf-8")
	public @ResponseBody String getLogincount(HttpSession session){
		 long count  = GraempinfSessionContext.getUserCount();
		 Map<String,Object> res = new HashMap<String, Object>();
		 res.put("count", String.valueOf(count));
		 return JsonUtil.toJson(res);
	}
	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs,HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String,Set<String>> allAuths = (Map<String,Set<String>>)session.getServletContext().getAttribute("allAuths");
		actions.addAll(allAuths.get("base"));
		for(Role r:rs) {
			if(r.getRoleType()==RoleType.ROLE_ADMIN) continue;
			if(null == allAuths.get(r.getRoleType().name()))continue;
			actions.addAll(allAuths.get(r.getRoleType().name()));
		}
		return actions;
	}
	
	
	private boolean isRole(List<Role> rs,RoleType rt) {
		for(Role r:rs) {
			if(r.getRoleType()==rt) return true;
		}
		return false;
	}
	
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 110; 
		int height = 45;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
		os.close();
		os.flush();
	}
}
