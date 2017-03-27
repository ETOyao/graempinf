package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.dao.IChannelDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IGroupDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.GroupChannel;
import com.wanglei.graempinf_core.graempinf_core.model.User;
@Service("groupService")
public class GroupService implements IGroupService {
	private IGroupDao groupDao;
	private IUserDao userDao;
      private IChannelDao channelDao;

	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	public IGroupDao getGroupDao() {
		return groupDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(String id) {
		List<User> users = userDao.listGroupUsers(id);
		if(null!=users && users.size()>0)throw new GraEmpInfException("删除的组中还有用户！不能删除！");
		groupDao.delete(id);
	}

	@Override
	public Group load(String id) {
		return groupDao.load(id);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listAllGroup();
	}

	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroup();
	}

	@Override
	public void deleteGroupUsers(String gid) {
		groupDao.deleteGroupUsers(gid);
	}
	@Override
	public void addGroupChannel(String gid, int cid) {
		Group g = groupDao.load(gid);
		Channel c =  channelDao.load(cid);
		if(c==null||g==null)throw new GraEmpInfException("要添加的组频道关联对象不存在");
		groupDao.addGroupChannel(g, c);
	}
	@Override
	public GroupChannel loadGroupChannel(String gid, int cid) {
		return groupDao.loadGroupChannel(gid, cid);
	}
	@Override
	public void clearGroupChannel(String gid) {
		groupDao.clearGroupChannel(gid);
	}
	@Override
	public void deleteGroupChannel(String gid, int cid) {
		groupDao.deleteGroupChannel(gid, cid);
	}
	@Override
	public List<Integer> listGroupChannelIds(String gid) {
		return groupDao.listGroupChannelIds(gid);
	}
	@Override
	public List<ChannelTree> generateGroupChannelTree(String gid) {
		return groupDao.generateGroupChannelTree(gid);
	}
	@Override
	public List<ChannelTree> generateUserChannelTree(String uid) {
		return groupDao.generateUserChannelTree(uid);
	}

}
