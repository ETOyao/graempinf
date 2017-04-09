package com.wanglei.graempinf.dwr;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.wanglei.graempinf.Webutils;
import com.wanglei.graempinf.controller.GroupController;
import com.wanglei.graempinf.service.IChannelService;
import com.wanglei.graempinf.service.IGroupService;
import com.wanglei.graempinf.service.IUserService;

@RemoteProxy(name="dwrService")
public class DwrService implements IDwrService{
	static Logger log = Logger.getLogger(GroupController.class);
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
	private IGroupService groupService;
	
	public IGroupService getGroupService() {
		return groupService;
	}
	@Inject
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	@RemoteMethod
	public void addGroupChannel(String gid, int cid,HttpSession session) {
		groupService.addGroupChannel(gid, cid);
		Webutils.putChannels(session, channelService);
	}

	@Override
	@RemoteMethod
	public void deleteGroupChannel(String gid, int cid,HttpSession session) {
		groupService.deleteGroupChannel(gid, cid);
		Webutils.putChannels(session, channelService);
	}
}
