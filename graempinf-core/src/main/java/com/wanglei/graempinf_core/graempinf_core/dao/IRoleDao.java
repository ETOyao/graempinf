package com.wanglei.graempinf_core.graempinf_core.dao;


import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.graempinf_core.graempinf_core.model.Role;

public interface  IRoleDao extends IBaseDao<Role> {
	/**
	 * <p>Description:查询角色列表<p>
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public List<Role>  listAllRoles();
	/**
	 * <p>Description:删除角色中用户<p>
	 * @param rid
	 * @author WangLei 2017年1月31日
	 */
	public void deleteRoleUsers(String rid);
}
