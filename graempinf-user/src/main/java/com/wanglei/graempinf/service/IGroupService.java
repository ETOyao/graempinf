package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.ChannelTree;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.GroupChannel;


public interface IGroupService {
	/**
	 * <p>Description:添加用户组<p>
	 * @author WangLei 2017年1月31日
	 */
	public void add(Group group);
	/**
	 * <p>Description:删除用户组<p>
	 * @author WangLei 2017年1月31日
	 */
	public void delete(String id);
	/**
	 * <p>Description:<p>
	 * @param id
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public Group load(String id);
	/**
	 * <p>Description:修改用户组信息<p>
	 * @param group
	 * @author WangLei 2017年1月31日
	 */
	public void update(Group group);
	/**
	 * <p>Description:用户组列表<p>
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public List<Group> listGroup();
	/**
	 * <p>Description:用户组分页<p>
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public Pager<Group> findGroup();
	/**
	 * <p>Description:删除用户组中的用户<p>
	 * @param id
	 * @author WangLei 2017年1月31日
	 */
	public void deleteGroupUsers(String gid);
	/**
	 * 添加GroupChannel对象
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(String gid,int cid);
	/**
	 * 加载GroupChannel对象
	 * @param gid
	 * @param cid
	 * @return
	 */
	public GroupChannel loadGroupChannel(String gid,int cid);
	/**
	 * 清空组所管理的栏目
	 * @param gid
	 */
	public void clearGroupChannel(String gid);
	/**
	 * 删除用户栏目
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(String gid,int cid);
	/**
	 * 获取某个组的所有管理栏目的id
	 * @param gid
	 * @return
	 */
	public List<Integer> listGroupChannelIds(String gid);
	/**
	 * 获取某个组的栏目树
	 * @param gid
	 * @return
	 */
	public List<ChannelTree> generateGroupChannelTree(String gid);
	/**
	 * 获取某个用户的栏目树
	 * @param uid
	 * @return
	 */
	public List<ChannelTree> generateUserChannelTree(String uid);
}
