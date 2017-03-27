package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public List<Role> listAllRoles() {
		return this.listByhql("from Role");
	}

	@Override
	public void deleteRoleUsers(String rid) {
		this.updateByHqlWithParam("delete from UserRole ur where ur.role.roleUuid = ?", rid);
	}

}
