package com.wanglei.graempinf.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.DateUtils;
import com.wanglei.basic.util.SecurityUtil;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.Enum.UserStatus;
import com.wanglei.graempinf_core.graempinf_core.dao.IEmpInfoDao;
import com.wanglei.graempinf_core.graempinf_core.dao.ISourceStudentDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IStudentDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;
import com.wanglei.graempinf_core.graempinf_core.model.Student;
import com.wanglei.graempinf_core.graempinf_core.model.User;
import com.wanglei.graempinf_core.graempinf_core.model.UserRole;
@Service("studentService")
public class StudentService implements IStudentService {
	Logger log = Logger.getLogger(StudentService.class);

	private IUserDao userDao ;
	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	private IStudentDao studentDao ;
	
	public IStudentDao getStudentDao() {
		return studentDao;
	}
	@Inject
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
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
	@Override
	public Student add(Student stu) {
		Student tempstu = studentDao.loadByStunum(stu.getStuNum());
		System.out.println(tempstu);
		if(null!=tempstu){
			log.error("添加的学生已经存在！");
			throw new GraEmpInfException("添加的学生已经存在！");		
		}
		User u = new User();
		u.setUserName(stu.getStuNum());
		try {
			u.setUserPassWord(SecurityUtil.md5(stu.getStuNum(),stu.getStuNum()));
		} catch (NoSuchAlgorithmException e) {
			log.error(e.fillInStackTrace());
			throw new GraEmpInfException("用户密码加密出错！");		
		}
		//添加学生信息
		studentDao.add(stu);
		u.setUserStatus(UserStatus.USER_STATUS_START.getIndex());
		u.setUserNickName(stu.getSutName());
		u.setStuUuid(stu.getStuUuid());
		u.setCreateDate(DateUtils.getCurrentTimestamp());
		// 添加用户信息
		userDao.add(u);
		u.setUserUuid(u.getUserUuid());
		Group g = new Group();
		g.setGruopUuid("402881e65a98acf4015a98c1c52a0008");
		//添加用户组和用户关系
		userDao.adduserGroup(u, g);
		//添加用户角色关系
		Role ro  = new Role();
		ro.setRoleUuid("402881e65a98acf4015a98b482330000");
		UserRole ur = new UserRole();
		ur.setRole(ro);
		ur.setUser(u);
		userDao.addUserRole(u, ro);
		//   添加生源地
		SourceStudent st = new SourceStudent();
		st.setSouExamNum(stu.getExamineeNum());
		st.setSouStuNum(stu.getStuNum());
		st.setSouIdcardNum(stu.getIdCardNum());
		st.setSouName(stu.getSutName());
		st.setFinshStatus(BaseCodeEnum.IS_FINSH_NO.getIndex());
		st.setSouStuUUid(stu.getStuUuid());
		sourceStudentDao.add(st);
		//  添加就业信息
		EmployedInfo emi = new EmployedInfo();
		emi.setEmpExaNum(stu.getExamineeNum());
		emi.setEmpStuNum(stu.getStuNum());
		emi.setEmpStuUUid(stu.getStuUuid());
		emi.setEmpName(stu.getSutName());
		emi.setFinshStatus(BaseCodeEnum.IS_FINSH_NO.getIndex());
		empInfoDao.add(emi);
		return null;
	}


	@Override
	public void delete(String id) {
		User u = userDao.loadUserByuStuUuid(id);
		if(null==u){throw new GraEmpInfException("删除学生信息出错！");}
		//删除用户关联的角色对象
		userDao.deleteUserRole(u.getUserUuid());
		//删除用户关联的组对象
		userDao.deleteUserGroup(u.getUserUuid());
		// 删除用户
		userDao.deleteUserBystuid(id);
		// 删除 生源地
		sourceStudentDao.deleteBystuid(id);
		//   删除 就业信息
		empInfoDao.deleteByStuUuid(id);
		studentDao.delete(id);
	}

	@Override
	public void delete(String[] ids) {
	if(null != ids && ids.length>0){
		for(int i=0;i<ids.length-1;i++){
			this.delete(ids[i]);	
		}
		}else{
		log.error("批量删除学生信息出错！删除学生信息为空！");
		throw new GraEmpInfException("删除学生信息出错！");	
	}
		
	}

	@Override
	public void update(Student stu) {
		try {
			String stuNum = stu.getStuNum();
			Student stu2m= this.listById(stu.getStuUuid());
			if(null==stu2m) throw new GraEmpInfException("更新学生信息出错！");
			//TODO 更新用户名
			User tu = userDao.loadUserByuStuUuid(stu.getStuUuid());
			tu.setUserName(stuNum);
			tu.setUserNickName(stu.getSutName());
			try {
				tu.setUserPassWord(SecurityUtil.md5(stuNum,stuNum));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			//TODO 更新生源信息
			String exnum = stu.getExamineeNum();
			String id = stu.getIdCardNum();
			String name = stu.getSutName();
			SourceStudent sst = sourceStudentDao.loadByStuNum(stu.getStuUuid());
			sst.setSouExamNum(exnum);
			sst.setSouIdcardNum(id);
			sst.setSouStuNum(stuNum);
			sst.setSouName(name);
			sourceStudentDao.update(sst);
			//TODO 更新就业信息
			EmployedInfo empi = empInfoDao.loadByStuNum(stu.getStuUuid());
			empi.setEmpExaNum(exnum);
			empi.setEmpStuNum(stuNum);
			empi.setEmpName(name);
			empInfoDao.upate(empi);
			studentDao.update(stu);
		} catch (Exception e) {
			log.error("更新学生信息出错");
			e.printStackTrace();
			throw new GraEmpInfException("更新学生信息失败！");
		}
	}

	@Override
	public Pager<Student> findByPager(Student stu) {
		return studentDao.findByPager(stu);
	}

	@Override
	public Student listById(String uuid) {
		return studentDao.load(uuid);
	}

	@Override
	public List<Student> listStudent(Student stu) {
		return studentDao.listStudent(stu);
	}
	@Override
	public List<String> listStuNums() {
		return studentDao.listStuNums();
	}
	@Override
	public void addStudents(List<Student> stus) {
		for(Student stu :stus){
			this.add(stu);
		}
	}
	@Override
	public void updateStudent(Student stu) {
		studentDao.update(stu);
	}
	
}
