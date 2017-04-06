package com.wanglei.graempinf.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class GraempinfSessionContext {
	private static final Map<String,HttpSession> ctx = new HashMap<String,HttpSession>();
	private GraempinfSessionContext(){}
	
	public static void addSessoin(HttpSession session) {
		ctx.put(session.getId(), session);
	}
	
	public static void removeSession(HttpSession session) {
		ctx.remove(session.getId());
	}
	
	public static HttpSession getSession(String sessionId) {
		return ctx.get(sessionId);
	}
	public static long getUserCount(){
		return ctx.size();
	}
	
	public static Map<String,HttpSession> getOnlineUsers(){
		return ctx;
	}
}
