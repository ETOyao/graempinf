package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Student;

public interface IStudentDao extends IBaseDao<Student> {
	/**
	 * <p>Description:添加学生信息<p>
	 * @param stu
	 * @author WangLei 2017年2月12日
	 */
	public Student add(Student stu);
	/**
	 * <p>Description:删除学生信息<p>
	 * @param stu
	 * @author WangLei 2017年2月12日
	 */
	public void delete(String id);
	/**
	 * <p>Description:修改学生信息<p>
	 * @param stu
	 * @author WangLei 2017年2月12日
	 */
	public void update(Student stu);
	/**
	 * <p>Description:分页查询<p>
	 * @param stu
	 * @return
	 * @author WangLei 2017年2月12日
	 */
	public Pager<Student> findByPager(Student stu);
	/**
	 * <p>Description:根据id查询<p>
	 * @return
	 * @author WangLei 2017年2月12日
	 */
	public Student listById(String uuid);
	/**
	 * <p>Description:查询列表<p>
	 * @param stu
	 * @return
	 * @author WangLei 2017年2月12日
	 */
	public List<Student> listStudent(Student stu); 
	/**
	 * <p>Description:根据学号查询<p>
	 * @param stuNum
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public Student loadByStunum(String stuNum);
	/**
	 * <p>Description:显示所有的学号<p>
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public List<String> listStuNums();
	
}
