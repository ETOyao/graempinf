package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.graempinf_core.graempinf_core.dao.IRoleDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;
@Service("roleService")
public class RoleService implements IRoleService {
	private IRoleDao roleDao;
	private IUserDao userDao;
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(String id) {
		List<User> users = userDao.listRoleUsers(id);
		if(null!= users && users.size()>0) throw new GraEmpInfException("要删除的角色中有用户不能删除");
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(String id) {
		return roleDao.load(id);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listAllRoles();
	}

	@Override
	public void deleteRoleUsers(String rid) {
		roleDao.deleteRoleUsers(rid);
	}

}
