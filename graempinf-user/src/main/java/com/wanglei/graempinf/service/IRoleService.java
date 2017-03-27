package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.graempinf_core.graempinf_core.model.Role;

public interface IRoleService {
	/**
	 * <p>Description:添加角色<p>
	 * @param role
	 * @author WangLei 2017年1月31日
	 */
	public void add(Role role);
	/**
	 * <p>Description:删除角色<p>
	 * @param id
	 * @author WangLei 2017年1月31日
	 */
	public void delete(String id);
	/**
	 * <p>Description:更新角色<p>
	 * @param role
	 * @author WangLei 2017年1月31日
	 */
	public void update(Role role);
	/**
	 * <p>Description:查找角色<p>
	 * @param id
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public Role load(String id);
	/**
	 * <p>Description:角色列表<p>
	 * @return
	 * @author WangLei 2017年1月31日
	 */
	public List<Role> listRole();
	/**
	 * <p>Description:删除角色中的用户<p>
	 * @param id
	 * @author WangLei 2017年1月31日
	 */
	public void deleteRoleUsers(String rid);
}
