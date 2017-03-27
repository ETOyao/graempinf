package com.wanglei.graempinf_core.graempinf_core;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.wanglei.basic.hibernate.model.SystemContext;
import com.wanglei.graempinf_core.graempinf_core.dao.IEmpInfoDao;
import com.wanglei.graempinf_core.graempinf_core.dao.ISourceStudentDao;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class SourceTest {
	@Inject
	private SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));

      }
	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	} 
	
	 private ISourceStudentDao sourceStudentDao;
	 public ISourceStudentDao getSourceStudentDao() {
			return sourceStudentDao;
		}
	 @Inject
	public void setSourceStudentDao(ISourceStudentDao sourceStudentDao) {
		this.sourceStudentDao = sourceStudentDao;
	}
	private IEmpInfoDao empInfoDao;
	
	public IEmpInfoDao getEmpInfoDao() {
		return empInfoDao;
	}
	@Inject
	public void setEmpInfoDao(IEmpInfoDao empInfoDao) {
		this.empInfoDao = empInfoDao;
	}
	public void testAdd(){
		SourceStudent sst = new SourceStudent();
		sst.setSouStuUUid("100664442");
		sst.setSouAddr("西安市");
		sst.setSouSouceType(1);
		sst.setFinshStatus(0);
		sst.setSouExamNum("22222dd52");
		sst.setSouHomeAddr("商洛的方法");
		sst.setSouIdcardNum("1112236");
		sst.setSouName("李四55");
		sst.setSouSouceType(2);
		sst.setSouIsLowPro(1);
		sst.setSouStuNum("1001");
		sourceStudentDao.add(sst);
	}
	 
	
	public void testLoad(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(12);
		SourceStudent sst = new SourceStudent();
		sst.setSouExamNum("22222dd52");
		List<SourceStudent> sol = sourceStudentDao.findByPager(sst).getDatas();
		System.out.println(sol);
	}
	
	public void testAddEmp(){
		EmployedInfo emif = new EmployedInfo();
		emif.setEmpAgreementNum("1001");
		emif.setEmpAttachment("r.txt");
		emif.setEmpDirection("软件");
		emif.setEmpExaNum("1000");
		emif.setEmpName("六六他");
		emif.setEmpRecordTranAddr("西安");
		emif.setEmpRecordTranUintPostCode("110110");
		emif.setEmpStuNum("1000");
		emif.setEmpUnitName("中软");
		empInfoDao.add(emif);
	}
	@Test
	public void testLoadEmp(){
		EmployedInfo emif = new EmployedInfo();
		emif.setEmpAgreementNum("1001");
		emif.setEmpAttachment("r.txt");
		emif.setEmpDirection("软件");
		emif.setEmpExaNum("1000");
		emif.setEmpName("六六他");
		emif.setEmpRecordTranAddr("西安");
		emif.setEmpRecordTranUintPostCode("110110");
		emif.setEmpStuNum("1000");
		emif.setEmpUnitName("中软");
		System.out.println(empInfoDao.findByPager(emif).getDatas());
	}
	 
	 
	 

}
