package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.dao.Tree;
import com.wanglei.graempinf_core.graempinf_core.model.Org;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;

public interface IOrgService {
	public void add(Org org);
	
	public void add(Org org,Integer pid);
	
	public void update(Org org);
	
	public void delete(int id);
	
	public Org load(int id);
	
	public Pager<Org> findByParent(Integer pid,Integer typeId);
	/**
	 * 根据组织类型来生成这颗树，如果tid为null，就获取所有的组织
	 * @param tid
	 * @return
	 */
	public List<Tree> tree();
	
	/**
	 * 获取某个组织下面的所在子组织id
	 * 需要进行判断，如果组织类型是NO_TYPE-->return null
	 * 如果组织类型是DEFAULT_TYPE-->返回该组织的所有子节点
	 * 如果组织类型是ALL_TYPE-->返回所有组织
	 * 如果组织类型是DEF_TYPE-->获取所有子组织下的子节点
	 * @param id
	 * @return
	 */
	public List<Integer> listAllChildIdsByOrg(int id);
	
	public List<Org> listAllChildByOrg(int id);
	/**
	 * 获取某个子组织下的所有的组织，也需要根据类型来进行获取
	 * @param id
	 * @return
	 */
	public List<Tree> listAllChildTreeByOrg(int id);
	
	
	/**
	 * 根据一个组织机构类型的编号获取父类的所有的组织机构节点，并且生成一棵树
	 * @param sn
	 * @return
	 */
	public List<Tree> listParentTreeByOrgType(String sn);
	/**
	 * <p>Description:将组织机构生成select<p>
	 * @return
	 * @author WangLei 2017年2月11日
	 */
	public List<SelectUtils> listOrgforSelect(Integer id,Integer typeId);
	public Org getOrgNameById(Integer id) ;
}
