package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;








import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.GroupChannel;
@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {

	@Override
	public List<Group> listAllGroup() {
		return this.listByhql("from Group");
	}

	@Override
	public Pager<Group> findGroup() {
		return this.findByhql("from Group");
	}

	@Override
	public void deleteGroupUsers(String gid) {
		this.updateByHqlWithParam("delete UserGroup ug where ug.group.gruopUuid=?",gid);
	}
	@Override
	public void addGroupChannel(Group group, Channel channel) {
		GroupChannel gc = this.loadGroupChannel(group.getGruopUuid(), channel.getId());
		if(gc!=null) return;
		gc = new GroupChannel();
		gc.setGroup(group);
		gc.setChannel(channel);
		this.getSession().save(gc);
	}

	@Override
	public GroupChannel loadGroupChannel(String gid, int cid) {
		return (GroupChannel)this.queryObjectByHqlWithParams("from GroupChannel where group.gruopUuid=? and channel.id=?",
				new Object[]{gid,cid});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> listGroupChannelIds(String gid) {
		String hql = "select gc.channel.id from GroupChannel gc where gc.group.gruopUuid=?";
		return this.getSession().createQuery(hql).setParameter(0, gid).list();
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(String gid) {
		String sql = "select c.id as id,c.name as name,c.pid as pid from " +
				"t_group_channel gc left join t_channel c on(gc.c_id=c.id) " +
				"where gc.g_id=?";
		List<ChannelTree> cts = this.listBysqlWithParam(sql,gid,ChannelTree.class, false);
		ChannelDao.initTreeNode(cts);
		return cts;
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(String uid) {
		String sql = "select distinct c.id as id,c.name as name,c.pid as pid from " +
				"t_group_channel gc left join t_channel c on(gc.c_id=c.id) left join t_user_group ug on(ug.g_uuid=gc.g_id)" +
				"where ug.u_uuid=?";
		List<ChannelTree> cts = this.listBysqlWithParam(sql,uid,ChannelTree.class, false);
		ChannelDao.initTreeNode(cts);
		return cts;
	}

	@Override
	public void clearGroupChannel(String gid) {
		this.updateByHqlWithParam("delete GroupChannel gc where gc.group.gruopUuid=?",gid);
	}

	@Override
	public void deleteGroupChannel(String gid, int cid) {
		this.updateByHqlWithParams("delete GroupChannel gc where gc.group.gruopUuid=? and gc.channel.id=?",new Object[]{gid,cid});
	}

}
