package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;
import com.wanglei.graempinf_core.graempinf_core.model.UserGroup;
import com.wanglei.graempinf_core.graempinf_core.model.UserRole;
public interface IUserDao extends IBaseDao<User> {
	/**
	 * <p>Description:获取用户的所有角色信息<p>
	 * @param userId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<Role> listUserRoles(String userId);
	/**
	 * <p>Description:获取用户所有的角色id<p>
	 * @param userId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<String> listUserRoleIdS(String userId);
	/**
	 * <p>Description:获取用户得用户组<p>
	 * @param userId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<Group> listUserGroups(String userId);
	/**
	 * <p>Description:获取用户的组Id<p>
	 * @param userId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<String> listuserGroupIdS(String userId);
	/**
	 * <p>Description:根据用户和角色Id获取用户角色关系<p>
	 * @param userId
	 * @param RoleId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public UserRole loadUserRole(String userId,String roleId);
	/**
	 * <p>Description:根据用户id和用户组id获取用户和组的关系<p>
	 * @param userId
	 * @param groupId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public UserGroup loadUserGroup(String userId,String groupId);
	/**
	 * <p>Description:根据用户名获取Id<p>
	 * @param userName
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public User loadByUserName(String userName);
	/**
	 * <p>Description:根据角色id获取用户列表<p>
	 * @param roleId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<User> listRoleUsers(String roleId);
	/**
	 * <p>Description:根据角色类型获取用户列表<p>
	 * @param roleType
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<User> listRoleUsers(RoleType roleType);
	/**
	 * <p>Description:根据用户组id获取用户<p>
	 * @param groupId
	 * @return
	 * @author WangLei 2017年1月21日
	 */
	public List<User> listGroupUsers(String groupId);
	/**
	 * <p>Description:添加用户-角色关系<p>
	 * @param user
	 * @param role
	 * @author WangLei 2017年1月22日
	 */
	public void addUserRole(User user ,Role role);
	/**
	 * <p>Description:添加用户-组关系<p>
	 * @param user
	 * @param role
	 * @author WangLei 2017年1月22日
	 */
	public void adduserGroup(User user, Group group);
	/**
	 * <p>Description:删除用户关联的用户组<p>
	 * @param userID
	 * @author WangLei 2017年1月30日
	 */
	public void deleteUserGroup(String userID);
	/**
	 * <p>Description:删除用户关联的用户角色<p>
	 * @author WangLei 2017年1月30日
	 */
	public void deleteUserRole(String userID);
	/**
	 * <p>Description:查询分页<p>
	 * @return
	 * @author WangLei 2017年1月30日
	 */
	public Pager<User> findUser();
	/**
	 * <p>Description:根据用户用户组id和角色ID删除用户角色对象<p>
	 * @param uid
	 * @param rid
	 * @author WangLei 2017年1月30日
	 */
	public void deleteUserRole(String uid,String rid);
	/**
	 * <p>Description:根据用户用户组id和角色ID删除用户组对象<p>
	 * @param uid
	 * @param rid
	 * @author WangLei 2017年1月30日
	 */
	public void deleteUserGroup(String uid,String rid);
	/**
	 * <p>Description:根据用户关联学生id删除用户<p>
	 * @param stuuid
	 * @author WangLei 2017年2月25日
	 */
	public void deleteUserBystuid(String stuuid);
	/**
	 * <p>Description:根据管理学生id查对象<p>
	 * @param stuuid
	 * @return
	 * @author WangLei 2017年2月25日
	 */
	public User loadUserByuStuUuid(String stuuid);
}
