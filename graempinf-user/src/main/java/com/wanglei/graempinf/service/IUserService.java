package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;

public interface IUserService {
	/**
	 * <p>Description:添加用户需要判断用户是否存在如果存在不能添加<p>
	 * @param user 用户对象
	 * @param rids 用户角色信息
	 * @param gids 用户组信息
	 * @author WangLei 2017年1月22日
	 */
	public void add(User user ,String [] rids ,String [] gids);
	/**
	 * <p>Description:删除用户要删除所有的用户角色和组信息<p>
	 * @param id 用户id
	 * @author WangLei 2017年1月22日
	 */
	public void delete(String id);
	/**
	 * <p>Description:更新用户信息，如果rids的角色在用户中已经存在不做操作，
	 * 如果rids在用户中不存在就要添加角色，如果用户的角色不存在于Rids中则要删除
	 * 用户组同理<p>
	 * @param user 用户
	 * @param rids 角色信息
	 * @param gids 用户id
	 * @author WangLei 2017年1月22日
	 */
	public void update(User user ,String [] rids ,String [] gids);
	/**
	 * <p>Description:更新用户状态。如果开启则停用如果停用则开启<p>
	 * @param uid 用户id
	 * @author WangLei 2017年1月22日
	 */
	
	public void updateStatus(String uid);
	/**
	 * 更新密码方法
	 * @param uid
	 * @param oldPwd
	 * @param newPwd
       * @author WangLei 2017年1月22日
	 */
	public void updatePwd(String uid,String oldPwd,String newPwd);
	public void update(User user) ;
	/**
	 * <p>Description:查询用户列表<p>
	 * @return 分页
	 * @author WangLei 2017年1月22日
	 */
	public Pager<User> findUserListByPage();
	public User loadUser(String uid);
	/**
	 * <p>Description:获取用户的所有角色信息<p>
	 * @param uid
	 * @return
	 * @author WangLei 2017年1月22日
	 */
	public List<Role> listUserRoles(String uid);
	/**
	 * <p>Description:获取用户的组信息<p>
	 * @param uid
	 * @return
	 * @author WangLei 2017年1月22日
	 */
	public List<Group> listUserGroup(String uid);
	/**
	 * <p>Description:获取用户的角色id<p>
	 * @param id
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public List<String> listRoleIds(String id);
	/**
	 * <p>Description:获取用户的组id<p>
	 * @param id
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public List<String> listGroupids(String id);
	
	/**
	 * <p>Description:查询组中用户<p>
	 * @param gruopUuid
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public List<User> listGroupUsers(String gruopUuid);
	/**
	 * <p>Description:查询角色中的用户<p>
	 * @param gruopUuid
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	public List<User>  listRoleUsers(String roleUuid);
	/**
	 * <p>Description:用户登录<p>
	 * @param username
	 * @param password
	 * @return
	 * @author WangLei 2017年2月5日
	 */
	public User login(String username, String password);
	/**
	 * <p>Description:获取当前登录用户<p>
	 * @return
	 * @author WangLei 2017年2月11日
	 */
	public User getCurentLoginUser();
}
