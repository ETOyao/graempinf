package com.wanglei.graempinf.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.web.GraempinfSessionContext;
import com.wanglei.graempinf_core.graempinf_core.model.User;

@Controller
@AuthClass("login")
public class AdminController {
	static Logger log = Logger.getLogger(AdminController.class);
		@RequestMapping("/admin")
	@AuthMethod
	public String index(){
		return "admin/index";
	}
	@RequestMapping("/admin/logout")
	@AuthMethod
	public String logout(HttpSession session) {
		User user = (User)session.getAttribute("loginUser");
		log.info("------------用户["+user.getUserNickName()+"]退出了系统--------");
		GraempinfSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/login";
	}
}
