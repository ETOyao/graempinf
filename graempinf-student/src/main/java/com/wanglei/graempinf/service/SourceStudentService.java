package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.dao.ISourceStudentDao;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;
@Service("sourceStudentService")
public class SourceStudentService implements ISourceStudnetService{
	private ISourceStudentDao sourceStudentDao;
	
	public ISourceStudentDao getSourceStudentDao() {
		return sourceStudentDao;
	}
	@Inject
	public void setSourceStudentDao(ISourceStudentDao sourceStudentDao) {
		this.sourceStudentDao = sourceStudentDao;
	}

	@Override
	public void update(SourceStudent sst) {
		sourceStudentDao.update(sst);
	}

	@Override
	public Pager<SourceStudent> findByPager(SourceStudent sst) {
		return sourceStudentDao.findByPager(sst);
	}

	@Override
	public List<SourceStudent> list(SourceStudent sst) {
		return sourceStudentDao.listSourceStduent(sst);
	}

	@Override
	public SourceStudent loadById(String id) {
		return sourceStudentDao.load(id);
	}
	@Override
	public SourceStudent loadByStunum(String stuNum) {
		return sourceStudentDao.loadByStuNum(stuNum);
	}
	
}
