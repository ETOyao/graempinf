package com.wanglei.graempinf.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.hibernate.model.UserSession;
import com.wanglei.basic.util.SecurityUtil;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.Enum.UserStatus;
import com.wanglei.graempinf_core.graempinf_core.dao.IGroupDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IRoleDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;
@Repository("userService")
public class UserService implements IUserService{
	static Logger log = Logger.getLogger(UserService.class);
	private IUserDao userDao;
	private IRoleDao roleDao;
	public IUserDao getUserDao() {
		return userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public IGroupDao getGroupDao() {
		return groupDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	private IGroupDao groupDao;
	@Override
	public void add(User user, String[] rids, String[] gids) {
		User temUser = userDao.loadByUserName(user.getUserName());
		if(null != temUser){
		  throw new GraEmpInfException("添加的用户已经存在不能添加！");
		}else{
			//添加用户
			Timestamp tempTime = new Timestamp(new Date().getTime());
			user.setCreateDate(tempTime);
			try {
				//用户密码加密
				user.setUserPassWord(SecurityUtil.md5(user.getUserName(),user.getUserPassWord()));
			} catch (NoSuchAlgorithmException e) {
				log.error(e.fillInStackTrace());
				throw new GraEmpInfException("用户密码加密出错！");
				
			}
			userDao.add(user);
		for(String rid : rids){//添加用户角色
			this.addUserUserRoe(user,rid);
		 }
		for(String gid : gids){
			this.addUserGroup(user,gid);
		}
		}
		
	}

	@Override
	public void delete(String id) {
		User u = userDao.load(id);
		if(StringUtils.isNotNull(u.getStuUuid())){
			throw new GraEmpInfException("该用户还有有关联的学生信息不能删除！");
		}
		//删除用户关联的角色对象
		userDao.deleteUserRole(id);
		//删除用户关联的组对象
		userDao.deleteUserGroup(id);
		//删除用户
		userDao.delete(id);
	}

	@Override
	public void update(User user, String[] rids, String[] gids) {
		//获取用户已经存在的组id和角色id
		List<String> erids = userDao.listUserRoleIdS(user.getUserUuid());
		List<String> egids = userDao.listuserGroupIdS(user.getUserUuid());
		//如果erids中不存在 rids就要添加 
		for(String rid :rids){
			if(!erids.contains(rid)){
				//添加角色
				this.addUserUserRoe(user, rid);
			}
		}
		for(String gid :gids){
			if(!egids.contains(gid)){
				//添加用户组
				this.addUserGroup(user, gid);
			}
		}
		//进行删除
		for(String erid:erids){
			if(!ArrayUtils.contains(rids, erid)){
				userDao.deleteUserRole(user.getUserUuid(), erid);
			}
		}
		//进行删除
		for(String egid:egids){
			if(!ArrayUtils.contains(gids, egid)){
				userDao.deleteUserGroup(user.getUserUuid(), egid);
			}
		}
		User u = userDao.load(user.getUserUuid());
		if(null == u)throw new GraEmpInfException("修改的用户不存在不能修改！");
		userDao.update(user);
	}
	
	private void addUserUserRoe(User user, String rid){
		//检测角色对象是否存在如果不存在抛出异常
		Role temRole  = roleDao.load(rid);
		if(null==temRole){
		  throw new GraEmpInfException("关联的用户角色不存在！");	
		}
		//检查用户和角色是否存在如果存在不添加 
		userDao.addUserRole(user, temRole);
	}
	private void addUserGroup(User user ,String gid){
		Group g = groupDao.load(gid);
		if(null == g) throw new GraEmpInfException("用户关联的组不存在不能添加！");
		userDao.adduserGroup(user, g);
	}
	@Override
	public void updateStatus(String uid) {
		User user = userDao.load(uid);
		if(null == user ) throw new GraEmpInfException("要修改的用户不存在！");
		user.setUserStatus(user.getUserStatus() == UserStatus.USER_STATUS_START.getIndex() ?
				UserStatus.USER_STATUS_STOP.getIndex() :
				UserStatus.USER_STATUS_START.getIndex());
	      userDao.update(user);
	}

	@Override
	public Pager<User> findUserListByPage() {
		return userDao.findUser();
	}

	@Override
	public User loadUser(String uid) {
		return userDao.load(uid);
	}

	@Override
	public List<Role> listUserRoles(String uid) {
		
		return userDao.listUserRoles(uid);
	}

	@Override
	public List<Group> listUserGroup(String uid) {
		
		return userDao.listUserGroups(uid);
	}

	@Override
	public List<String> listRoleIds(String id) {
		return userDao.listUserRoleIdS(id);
	}

	@Override
	public List<String> listGroupids(String id) {
		return userDao.listuserGroupIdS(id);
	}

	@Override
	public List<User>  listGroupUsers(String gruopUuid) {
		return userDao.listGroupUsers(gruopUuid);
	}

	@Override
	public List<User>  listRoleUsers(String roleUuid) {
		return userDao.listRoleUsers(roleUuid);
	}
	@Override
	public User login(String username, String password) {
		User user = userDao.loadByUserName(username);
		if(user==null) throw new GraEmpInfException("用户名或者密码不正确");
		try {
			if(!SecurityUtil.md5(username,password).equals(user.getUserPassWord())) {
				throw new GraEmpInfException("用户名或者密码不正确");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new GraEmpInfException("密码加密失败:"+e.getMessage());
		}
		if(user.getUserStatus()==0) throw new GraEmpInfException("用户已经停用，请与管理员联系");
		return user;
	}
	@Override
	public void updatePwd(String uid, String oldPwd, String newPwd) {
		try {
			User u = userDao.load(uid);
			if(!SecurityUtil.md5(u.getUserName(),oldPwd).equals(u.getUserPassWord())) {
				throw new GraEmpInfException("原始密码输入不正确");
			}
			u.setUserPassWord(SecurityUtil.md5(u.getUserName(), newPwd));
			userDao.update(u);
		} catch (NoSuchAlgorithmException e) {
			throw new GraEmpInfException("更新密码失败:"+e.getMessage());
		}
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User getCurentLoginUser() {
		return UserSession.get("loginUser", User.class);
	}

}
