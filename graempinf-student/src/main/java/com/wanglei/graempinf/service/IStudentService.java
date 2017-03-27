package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Student;

public interface IStudentService {
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
	 * <p>Description:批量删除学生信息<p>
	 * @param ids
	 * @author WangLei 2017年2月12日
	 */
	public void delete(String [] ids);
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
	 * <p>Description:获取所有学号<p>
	 * @return
	 * @author WangLei 2017年2月24日
	 */
	public List<String> listStuNums();
	/**
	 * <p>Description:批量导入学生信息<p>
	 * @param stus 
	 * @author WangLei 2017年2月24日
	 */
	public void addStudents(List<Student> stus);
	/**
	 * <p>Description:只是更新学生信息不关联更新其他信息<p>
	 * @param stu
	 * @author wanglei 2017年3月19日
	 */
	public void updateStudent(Student stu);
}
