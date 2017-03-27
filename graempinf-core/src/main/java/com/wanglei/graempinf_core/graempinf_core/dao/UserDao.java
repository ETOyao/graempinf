package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;
import com.wanglei.graempinf_core.graempinf_core.model.UserGroup;
import com.wanglei.graempinf_core.graempinf_core.model.UserRole;
@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao{
	Logger log = Logger.getLogger(StudentDao.class);
	@Override
	public List<Role> listUserRoles(String userId) {
		String hql = "select ur.role from UserRole ur where ur.user.userUuid=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}


	@Override
	public List<String> listUserRoleIdS(String userId) {
		String hql = "select ur.role.roleUuid from UserRole ur where ur.user.userUuid=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public List<Group> listUserGroups(String userId) {
		String hql = "select ug.group from UserGroup ug where ug.user.userUuid=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public List<String> listuserGroupIdS(String userId) {
		String hql = "select ug.group.gruopUuid from UserGroup ug where ug.user.userUuid = ?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public UserRole loadUserRole(String userId, String roleId) {
		String hql ="select ur from UserRole ur left join fetch ur.user u left join ur.role r where u.userUuid = ? and r.roleUuid =?";
		return (UserRole)this.getSession().createQuery(hql).setParameter(0, userId).setParameter(1, roleId).uniqueResult();
	}

	@Override
	public UserGroup loadUserGroup(String userId, String groupId) {
		String hql ="select ug from UserGroup ug left join fetch ug.user u left join fetch ug.group g where u.userUuid = ? and g.gruopUuid =?";
		return (UserGroup)this.getSession().createQuery(hql).
				setParameter(0, userId).setParameter(1, groupId).uniqueResult();
	}

	@Override
	public User loadByUserName(String userName) {
		String hql = "from User where userName =?";
		return (User)this.queryObjectByHqlWithParam(hql, userName);
	}

	@Override
	public List<User> listRoleUsers(String roleId) {
		String hql = "select ur.user from UserRole ur where ur.role.roleUuid= ?";
		return this.listByhqlWithParam(hql, roleId);
	}

	@Override
	public List<User> listRoleUsers(RoleType roleType) {
		String hql = "select ur.user from UserRole ur where ur.role.roleType=?";
		return this.listByhqlWithParam(hql, roleType);
	}

	@Override
	public List<User> listGroupUsers(String groupId) {
		String hql = "select ug.user from UserGroup ug where ug.group.gruopUuid=?";
		return this.listByhqlWithParam(hql, groupId);
	}


	@Override
	public void addUserRole(User user, Role role) {
		UserRole ur = this.loadUserRole(user.getUserUuid(), role.getRoleUuid());
		if(null != ur)return;
		ur = new UserRole();
		ur.setRole(role);
		ur.setUser(user);
		this.getSession().save(ur);
	}


	@Override
	public void adduserGroup(User user, Group group) {
		UserGroup ug = this.loadUserGroup(user.getUserUuid(), group.getGruopUuid());
		if(null != ug)return;
		ug = new UserGroup();
		ug.setGroup(group);
		ug.setUser(user);
		this.getSession().save(ug);
	}


	@Override
	public void deleteUserGroup(String userID) {
		String hql = "delete from UserGroup ug where ug.user.userUuid = ?";
		this.updateByHqlWithParam(hql, userID);
	}


	@Override
	public void deleteUserRole(String userID) {
		String hql = "delete from UserRole ur where ur.user.userUuid = ?";
		this.updateByHqlWithParam(hql, userID);
	}


	@Override
	public Pager<User> findUser() {
		return this.findByhql("from User");
	}


	@Override
	public void deleteUserRole(String uid, String rid) {
		String hql = "delete UserRole ur where ur.user.userUuid = ? and ur.role.roleUuid =?";
		this.updateByHqlWithParams(hql, new Object[]{uid,rid});
	}


	@Override
	public void deleteUserGroup(String uid, String rid) {
		String hql = "delete UserGroup ug where ug.user.userUuid =? and ug.group.gruopUuid =?";
		this.updateByHqlWithParams(hql, new Object[]{uid,rid});
	}


	@Override
	public void deleteUserBystuid(String stuuid) {
		String hql ="delete User u where u.stuUuid =?";
		this.updateByHqlWithParam(hql, stuuid);
	}


	@Override
	public User loadUserByuStuUuid(String stuuid) {
		String hql ="from User u where u.stuUuid =?";
		return (User)this.listByhqlWithParam(hql, stuuid).get(0);
	}

}
