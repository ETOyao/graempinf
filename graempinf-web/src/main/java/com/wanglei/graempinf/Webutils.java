package com.wanglei.graempinf;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.wanglei.graempinf.service.IChannelService;

public class Webutils {
	
	public  static void putChannels(HttpSession session,IChannelService channelService){
		ServletContext application = session.getServletContext();
		application.setAttribute("channels", channelService.listTopNavChannel(session.getAttribute("useruuid").toString()));
	}
}
