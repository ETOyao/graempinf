package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.graempinf_core.graempinf_core.Enum.ChannelType;
import com.wanglei.graempinf_core.graempinf_core.dao.IChannelDao;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;

@Service("channelService")
public class ChannelService implements IChannelService {
	private IChannelDao channelDao;
	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	public void add(Channel channel, Integer pid) {
		Integer orders = channelDao.getMaxOrderByParent(pid);
		if(pid!=null&&pid>0) {
			Channel pc = channelDao.load(pid);
			if(pc==null) throw new GraEmpInfException("要添加栏目的父类对象不正确!");
			channel.setParent(pc);
		}
		channel.setOrders(orders+1);
		channelDao.add(channel);
	}

	public void update(Channel channel) {
		channelDao.update(channel);
	}

	public void delete(int id) {
		//1、需要判断是否存在子栏目
		List<Channel> cs = channelDao.listByParent(id);
		if(cs!=null&&cs.size()>0) throw new GraEmpInfException("要删除的栏目还有子栏目，无法删除");
		//2、需要删除和组的关联关系
		channelDao.deleteChannelGroups(id);
		channelDao.delete(id);
	}

	

	public Channel load(int id) {
		return channelDao.load(id);
	}

	public List<Channel> listByParent(Integer pid) {
		return channelDao.listByParent(pid);
	}
	@Override
	public List<ChannelTree> generateTree() {
		return channelDao.generateTree();
	}
	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		return channelDao.generateTreeByParent(pid);
	}
	@Override
	public void updateSort(Integer[] ids) {
		channelDao.updateSort(ids);
	}
	@Override
	public List<Channel> listPublishChannel() {
		return channelDao.listPublishChannel();
	}
	@Override
	public List<ChannelTree> listTopNavChannel(String uuid) {
		return channelDao.listTopNavChannel(uuid);
	}
	@Override
	public List<Channel> listAllIndexChannel(ChannelType ct) {
		return channelDao.listAllIndexChannel(ct);
	}

	@Override
	public Channel loadFirstChannelByNav(int cid) {
		return channelDao.loadFirstChannelByNav(cid);
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer cid) {
		return channelDao.listUseChannelByParent(cid);
	}

	@Override
	public List<Channel> listChannelByType(ChannelType ct) {
		return channelDao.listChannelByType(ct);
	}
	

}
