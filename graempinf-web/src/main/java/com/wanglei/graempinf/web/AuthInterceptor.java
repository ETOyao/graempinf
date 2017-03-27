package com.wanglei.graempinf.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wanglei.basic.hibernate.model.UserSession;
import com.wanglei.graempinf.controller.UserContller;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	static Logger log = Logger.getLogger(UserContller.class);
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		/*
		 * 如果使用uploadify进行文件的上传，由于flash的bug问题，会产生一个新的session，此时验证失败
		 * 所以必须在此处获取一个原有的session，然后重置session信息
		 */
		String sid = request.getParameter("sid");
		if(sid!=null&&!"".equals(sid.trim())) {
			//当sid有值，就表示是通过uploadify上传文件，此时就应该获取原有的session
			session = GraempinfSessionContext.getSession(sid);
		}
		HandlerMethod hm = (HandlerMethod)handler;
		User user = (User)session.getAttribute("loginUser");
		if(user==null) {
			request.setAttribute("logginTimeOut", true);
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		} else {
			boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
			if(!isAdmin) {
				//不是超级管理人员，就需要判断是否有权限访问某些功能
				Set<String> actions = (Set<String>)session.getAttribute("allActions");
				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!actions.contains(aname)) {
				log.warn("--------------用户：["+user.getUserName()+"]访问资源"+aname+"受到权限限制!----------");
				throw new GraEmpInfException("没有权限访问该功能，请联系管理员");};
			}
			 UserSession.set("userSession", session);
		     UserSession.set("loginUser", user);
		}
		return super.preHandle(request, response, handler);
	}
}
