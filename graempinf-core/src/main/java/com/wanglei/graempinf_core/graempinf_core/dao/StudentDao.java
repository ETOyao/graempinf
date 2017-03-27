package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.model.Student;
@Repository("studentDao")
public class StudentDao extends BaseDao<Student> implements IStudentDao {
	Logger log = Logger.getLogger(StudentDao.class);
	@Override
	public void delete(String id) {
		super.delete(id);
	}

	@Override
	public Student load(String id) {
		return super.load(id);
	}


	@Override
	public Student add(Student stu) {
		stu.setFinshStatus(BaseCodeEnum.IS_FINSH_NO.getIndex());
		return super.add(stu);
	}
	@Override
	public void update(Student stu) {
		super.update(stu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Student> findByPager(Student stu) {
		Map<String ,Object>  obj = this.getSql(stu);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return findByHqlWithalias(sql, alias);
	}
	private Map<String ,Object> getSql (Student stu){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "SELECT "
				+ "new Student (stuUuid,examineeNum,stuNum,"
				+ "sutName,stuTeam,"
				+ "idCardNum,collegeName,deptName,"
				+ "gender,finshStatus) "
				+ "from Student as stu where 1=1";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(stu!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(stu.getStuNum() )){
				sbf.append(" and stu.stuNum like:stuNum ");
				alias.put("stuNum",StringUtils.gennerateLike(stu.getStuNum()));
			}if(StringUtils.isNotNull(stu.getSutName())){
				sbf.append(" and stu.sutName like:stuName");
				alias.put("stuName",StringUtils.gennerateLike(stu.getSutName()));
			} if(StringUtils.isNotNull(stu.getStuTeam())){
				sbf.append(" and stu.stuTeam like:stuTeam");
				alias.put("stuTeam",StringUtils.gennerateLike(stu.getStuTeam()));
			} if(StringUtils.isNotNull(stu.getCollegeName())){
				sbf.append(" and stu.collegeName like:colle");
				alias.put("colle",StringUtils.gennerateLike(stu.getCollegeName()));
			} if(StringUtils.isNotNull(stu.getDeptName())){
				sbf.append(" and stu.deptName like:dept");
				alias.put("dept",StringUtils.gennerateLike(stu.getDeptName() ));
			} if(null!=stu.getFinshStatus()){
				if(stu.getFinshStatus()==0 ||stu.getFinshStatus()==9){
				sbf.append(" and stu.finshStatus =:finshStatus");
				sbf.append(" and stu.finshStatus =:finshStatus");
				alias.put("finshStatus",stu.getFinshStatus());
				}
				
			} if(StringUtils.isNotNull(stu.getIdCardNum())){
				sbf.append(" and stu.idCardNum like:idcard");
				alias.put("idcard",StringUtils.gennerateLike(stu.getIdCardNum()));
			} if(StringUtils.isNotNull(stu.getExamineeNum())){
				sbf.append(" and stu.examineeNum like:examNum");
				alias.put("examNum",StringUtils.gennerateLike(stu.getExamineeNum()));
			}if(StringUtils.isNotNull(stu.getBeforecensusaddr())){
				sbf.append(" and stu.beforecensusaddr like:readdr");
				alias.put("readdr",StringUtils.gennerateLike(stu.getBeforecensusaddr()));
			}if(StringUtils.isNotNull(stu.getBeforerecordaddr())){
				sbf.append(" and stu.beforerecordaddr like:recddr");
				alias.put("recddr",StringUtils.gennerateLike(stu.getBeforerecordaddr()));
			}
			
			
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj ;
	}
	@Override
	public Student listById(String uuid) {
		return super.load(uuid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent(Student stu) {
		Map<String ,Object>  obj = this.getSql(stu);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return listByhqlWithAlias(sql, alias);
	}

	@Override
	public Student loadByStunum(String stuNum) {
		String hql = "  FROM Student st where st.stuNum= ?";
		return (Student) super.queryObjectByHqlWithParam(hql, stuNum);
	}

	@Override
	public List<String> listStuNums() {
		String sql = "SELECT stuNum FROM Student";
		return super.listObj(sql);
	}
	
	
}
