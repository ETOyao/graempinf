package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.Enum.ChannelType;

@Repository("channelDao")
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {
	
	public static void initTreeNode(List<ChannelTree> cts) {
		cts.add(0,new ChannelTree(Channel.ROOT_ID,Channel.ROOT_NAME,-1,""));
		for(ChannelTree ct:cts) {
			if(ct.getPid()==null)ct.setPid(0);
		}
	}

	@Override
	public List<Channel> listByParent(Integer pid) {
		String hql = "select c from Channel c left join fetch c.parent cp where cp.id="+pid+" order by c.orders";
		if(pid==null||pid==0) hql = "select c from Channel c where c.parent is null order by c.orders";
		return this.listByhql(hql);
	}

	@Override
	public int getMaxOrderByParent(Integer pid) {
		String hql = "select max(c.orders) from Channel c where c.parent.id="+pid;
		if(pid==null||pid==0) hql = "select max(c.orders) from Channel c where c.parent is null";
		Object obj = this.queryObjectByHql(hql);
		if(obj==null) return 0;
		return (Integer)obj;
	}

	@Override
	public List<ChannelTree> generateTree() {
		String sql = "select id,name,pid from t_channel order by orders";
		List<ChannelTree> cts = this.listBysql(sql, ChannelTree.class, false);
		initTreeNode(cts);
		return cts;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		if(pid==null||pid==0) {
			return this.listBysql("select id,name,pid from t_channel where pid is null order by orders", ChannelTree.class, false);
		} else {
			return this.listBysql("select id,name,pid from t_channel where pid="+pid+" order by orders", 
					ChannelTree.class,false);
		}
	}

	@Override
	public void updateSort(Integer[] ids) {
		int index = 1;
		String hql = "update Channel c set c.orders=? where c.id=?";
		for(Integer id:ids) {
			this.updateByHqlWithParams(hql, new Object[]{index++,id});
		}
	}

	@Override
	public List<Channel> listPublishChannel() {
		String hql = "select new Channel(c.id,c.name) from Channel c where c.status=0 and c.type!="+ChannelType.NAV_CHANNEL_TITLE.ordinal();
		return this.listByhql(hql);
	}

	@Override
	public List<ChannelTree> listTopNavChannel(String uuid) {
		String sql = "select distinct c.id as id,c.name as name,c.pid as pid ,c.custom_link_url as url from " +
				"t_group_channel gc left join t_channel c on(gc.c_id=c.id) left join t_user_group ug on(ug.g_uuid=gc.g_id)" +
				"where ug.u_uuid=? order by orders";
		List<ChannelTree> cts = this.listBysqlWithParam(sql,uuid ,ChannelTree.class, false);
		initTreeNode(cts);
		return cts;
	}

	@Override
	public List<Channel> listAllIndexChannel(ChannelType ct) {
		String hql = "select new Channel(c.id,c.name) " +
				"from Channel c where c.status=0 and c.isIndex=1";
		if(ct!=null) {
			hql+=" and c.type="+ct.ordinal();
		}
		return this.listByhql(hql);
	}

	@Override
	public void deleteChannelGroups(int cid) {
		String hql = "delete GroupChannel gc where gc.channel.id=?";
		this.getSession().createQuery(hql).setParameter(0, cid).executeUpdate();
	}

	@Override
	public Channel loadFirstChannelByNav(int pid) {
		String hql = "select new Channel(c.id,c.name,c.type) from Channel c where c.parent.id=? order by c.orders";
		return (Channel)this.getSession().createQuery(hql)
			.setFirstResult(0).setMaxResults(1).setParameter(0, pid).uniqueResult();
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer pid) {
		String hql = "select c from Channel c left join fetch c.parent cp where cp.id="+pid+" and cp.status=0 order by c.orders";
		if(pid==null||pid==0) hql = "select c from Channel c where c.parent is null and cp.status=0 order by c.orders";
		return this.listByhql(hql);
	}

	@Override
	public List<Channel> listChannelByType(ChannelType ct) {
		String hql = "select new Channel(c.id,c.name) from Channel c where c.status= 0 and c.type=?";
		return this.listByhqlWithParam(hql,ct);
	}

}
