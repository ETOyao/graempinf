package com.wanglei.graempinf_core.graempinf_core;

import java.util.List;
import java.util.Random;

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

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.hibernate.model.SystemContext;
import com.wanglei.basic.util.DateUtils;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.dao.IStudentDao;
import com.wanglei.graempinf_core.graempinf_core.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class StudentTest {
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
	private IStudentDao studentDao;
	public IStudentDao getStudentDao() {
		return studentDao;
	}
	@Inject
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}
	Random ran = new Random();
	
	public void testAdd (){
		for(int i=14;i<50;i++) {
			Student stu = new Student();
			stu.setBeforecensusaddr("陕西西安");
			stu.setBeforerecordaddr("陕西商洛");
			stu.setBirthDate(DateUtils.getCurrentSqlDate());
			stu.setCensusIsTranSchool(BaseCodeEnum.IS_TRAN_YES.getIndex());
			stu.setCollegeName("信息工程学院");
			stu.setDeptName("软件工程");
			stu.setCollegeNum("0123");
			stu.setDeptNnum("90999");
			stu.setEducation("本科");
			stu.setEductionalSystme("四年本科");
			stu.setEmail(getName()+"@qq.com");
			stu.setEnterTime(DateUtils.getCurrentSqlDate());
			stu.setExamineeNum("125025996"+i);
			stu.setFinshStatus(BaseCodeEnum.IS_FINSH_NO.getIndex());
			stu.setGender(BaseCodeEnum.GENDER_MALE.getIndex());
			stu.setGraduateTime(DateUtils.getCurrentSqlDate());
			stu.setIdCardNum("10256693223"+i);
			stu.setMajor("软件工程");
			stu.setNation("汉");
			stu.setPhone("110");
			stu.setSutName(getName());
			stu.setStuNum("1402130532");
			stu.setTrainingMethod("非定向");
			studentDao.add(stu);
		}
		
	}
	private String getName() {
		String[] name1 = new String[]{"孔","张","叶","李","叶入","孔令",
				"张立","陈","刘","牛","夏侯","令","令狐","赵","母","穆","倪",
				"张毅","称","程","王","王志","刘金","冬","吴","马","沈"};
		
		String[] name2 = new String[]{"凡","课","颖","页","源","都",
				"浩","皓","西","东","北","南","冲","昊","力","量","妮",
				"敏","捷","杰","坚","名","生","华","鸣","蓝","春","虎","刚","诚"};
		
		String[] name3 = new String[]{"吞","明","敦","刀","备","伟",
				"唯","楚","勇","诠","佺","河","正","震","点","贝","侠",
				"伟","大","凡","琴","青","林","星","集","财"};
		
		boolean two = ran.nextInt(50)>=45?false:true;
		if(two) {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2;
			int n = ran.nextInt(10);
			if(n>5) {
				n2 = name2[ran.nextInt(name2.length)];
			} else {
				n2 = name3[ran.nextInt(name3.length)];
			}
			return n1+n2;
		} else {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2 = name2[ran.nextInt(name2.length)];
			String n3 = name3[ran.nextInt(name3.length)];
			return n1+n2+n3;
		}
	}
	@Test
	public void testFind (){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(12);
		Student stu = new Student();
		stu.setBeforecensusaddr("陕西西安");
		stu.setBeforerecordaddr("陕西商洛");
		stu.setCollegeName("信息工程学院");
		stu.setDeptName("软件工程");
		stu.setEmail(getName()+"@qq.com");
		stu.setEnterTime(DateUtils.getCurrentSqlDate());
		stu.setExamineeNum("125025996");
		stu.setFinshStatus(BaseCodeEnum.IS_FINSH_NO.getIndex());
		stu.setGender(BaseCodeEnum.GENDER_MALE.getIndex());
		stu.setGraduateTime(DateUtils.getCurrentSqlDate());
		stu.setIdCardNum("");
		stu.setMajor("");
		stu.setNation("汉");
		stu.setPhone("110");
		stu.setSutName(getName());
		stu.setStuNum("1402130532");
		stu.setTrainingMethod("非定向");
       	Pager<Student> p = studentDao.findByPager(stu);
		List<Student> stus =p.getDatas();
		System.out.println(stus.size());
		for(Student stu1:stus){
			System.out.println(stu1);	
		}
//		System.out.println(studentDao.load("297eccbb5a325df1015a325df49e0000"));
		
	}
}
