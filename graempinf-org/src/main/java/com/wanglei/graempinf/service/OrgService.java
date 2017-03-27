package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.dao.IOrgDao;
import com.wanglei.graempinf_core.graempinf_core.dao.Tree;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Org;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;
@Service("orgService")
public class OrgService implements IOrgService {
	static Logger log = Logger.getLogger(OrgService.class);
	@Inject
	private IOrgDao orgDao;
	public IOrgDao getOrgDao() {
		return orgDao;
	}

	public void setOrgDao(IOrgDao orgDao) {
		this.orgDao = orgDao;
	}
	
	@Override
	public void add(Org org) {
		if(org.getParent()==null) {
			org.setOrderNum(orgDao.getMaxOrder(null)+1);
		} else {
			org.setOrderNum(orgDao.getMaxOrder(org.getParent().getId())+1);
		}
		
		orgDao.add(org);
	}

	@Override
	public void add(Org org, Integer pid) {
		Integer orders = orgDao.getMaxOrder(pid);
		if(pid!=null&&pid>0) {
			Org p = orgDao.load(pid);
			if(p==null) throw new GraEmpInfException("要添加的父亲组织不存在!");
			org.setParent(p);
		}
		org.setOrderNum(orders+1);
		orgDao.add(org);
	}

	@Override
	public void update(Org org) {
		orgDao.update(org);

	}

	@Override
	public void delete(int id) {
		List<Org> childs = orgDao.listChilds(id);
		if(null!=childs && childs.size()>0 ){
			log.info("要删除的机构有子机构不能删除！");
			throw new GraEmpInfException("要删除的机构有子机构不能删除！请先删除子机构！");
		}
		// TODO 需要判断机构是下是否有人，有人则不能删除
		orgDao.delete(id);
		
	}

	@Override
	public Org load(int id) {
		return orgDao.load(id);
	}

	@Override
	public Pager<Org> findByParent(Integer pid, Integer typeId) {
		return orgDao.findByParent(pid,typeId);
	}

	@Override
	public List<Tree> tree() {
		return orgDao.tree();
	}

	@Override
	public List<Integer> listAllChildIdsByOrg(int id) {
		return orgDao.listAllChildIdsByOrg(id);
	}


	@Override
	public List<Org> listAllChildByOrg(int id) {
		return orgDao.listAllChildByOrg(id);
	}

	@Override
	public List<Tree> listAllChildTreeByOrg(int id) {
		return orgDao.listAllChildTreeByOrg(id);
	}



	@Override
	public List<Tree> listParentTreeByOrgType(String sn) {
		return orgDao.listParentTreeByOrgType(sn);
	}

	@Override
	public List<SelectUtils> listOrgforSelect(Integer id,Integer typeId) {
		return orgDao.createOrForSelect(id,typeId);
	}

	@Override
	public Org getOrgNameById(Integer id) {
		return orgDao.getOrgNameById(id);
	}
}
