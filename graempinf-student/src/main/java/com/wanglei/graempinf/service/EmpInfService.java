package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.dao.IEmpInfoDao;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;
@Service("empInfoService")
public class EmpInfService implements IEmpInfService {
	private IEmpInfoDao empInfoDao;
	
	public IEmpInfoDao getEmpInfoDao() {
		return empInfoDao;
	}
	@Inject
	public void setEmpInfoDao(IEmpInfoDao empInfoDao) {
		this.empInfoDao = empInfoDao;
	}

	@Override
	public void update(EmployedInfo empi) {
		empInfoDao.upate(empi);
	}

	@Override
	public Pager<EmployedInfo> findBypage(EmployedInfo empi) {
		return empInfoDao.findByPager(empi);
	}

	@Override
	public EmployedInfo loadByuuid(String id) {
		return empInfoDao.load(id);
	}

	@Override
	public List<EmployedInfo> list(EmployedInfo empi) {
		return empInfoDao.listEmpinf(empi);
	}
	@Override
	public List<SelectUtils> listByType(String type) {
		return empInfoDao.listByType(type);
	}
	@Override
	public EmployedInfo loadBystuid(String stuuid) {
		return empInfoDao.loadByStuNum(stuuid);
	}

}
