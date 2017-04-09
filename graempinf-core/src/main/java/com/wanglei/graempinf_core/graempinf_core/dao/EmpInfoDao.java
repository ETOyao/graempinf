package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.EmpInfoCount;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;
@Repository("empInfoDao")
public  class EmpInfoDao extends BaseDao<EmployedInfo> implements IEmpInfoDao {
	@Override
	public EmployedInfo add(EmployedInfo empi){
		return super.add(empi);
	}
	@Override
	public void upate(EmployedInfo empi) {
		super.update(empi);
	}

	@Override
	public void delete(String id) {
		super.delete(id);
	}
	@Override
	public EmployedInfo lodbyId(String uuid) {
		return super.load(uuid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<EmployedInfo> findByPager(EmployedInfo empInf) {
		Map<String ,Object>  obj = this.getSql(empInf);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return findByHqlWithalias(sql, alias);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployedInfo> listEmpinf(EmployedInfo empInf) {
		Map<String ,Object>  obj = this.getSql(empInf);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return listByhqlWithAlias(sql, alias);
	}
	private Map<String ,Object> getSql (EmployedInfo tm){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = " from EmployedInfo tm"
			      +" where 1=1";
			sbf.append(sql);
		Map<String, Object> alias = null;
		if(tm!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(tm.getEmpExaNum())){
				sbf.append(" and tm.empExaNum like:empExaNum");
				alias.put("empExaNum",StringUtils.gennerateLike(tm.getEmpExaNum()));
			
			}if(StringUtils.isNotNull(tm.getEmpStuNum())){
				sbf.append(" and tm.empStuNum like:empStuNum");
				alias.put("empStuNum",StringUtils.gennerateLike(tm.getEmpStuNum()));
			
			}if(StringUtils.isNotNull(tm.getEmpName())){
				sbf.append(" and tm.empName like:empName");
				alias.put("empName",StringUtils.gennerateLike(tm.getEmpName()));
			
			}if(StringUtils.isNotNull(tm.getEmpAgreementNum())){
				sbf.append(" and tm.empAgreementNum like:amn");
				alias.put("amn",StringUtils.gennerateLike(tm.getEmpAgreementNum()));
			
			}if(StringUtils.isNotNull(tm.getEmpUnitName())){
				sbf.append(" and tm.empUnitName like:empUnitName");
				alias.put("empUnitName",StringUtils.gennerateLike(tm.getEmpUnitName()));
			
			}if(StringUtils.isNotNull(tm.getEmpDirection())){
				sbf.append(" and tm.empDirection like:empDirection");
				alias.put("empDirection",StringUtils.gennerateLike(tm.getEmpDirection()));
			
			}
			if(null!=tm.getFinshStatus()){
				if(tm.getFinshStatus()==0 ||tm.getFinshStatus()==9){
				sbf.append(" and tm.finshStatus =:finshStatus");
				sbf.append(" and tm.finshStatus =:finshStatus");
				alias.put("finshStatus",tm.getFinshStatus());
				}
			}if(null!=tm.getEmpUnitType()){
				if(tm.getEmpUnitType()!=0){
				sbf.append(" and tm.empUnitType =:empUnitType");
				sbf.append(" and tm.empUnitType =:empUnitType");
				alias.put("empUnitType",tm.getEmpUnitType());
				}
			}
				
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj;
	}
	@Override
	public void deleteByStuUuid(String stuUuid) {
		String hql = "delete from EmployedInfo emi where emi.empStuNum = ?";
		super.updateByHqlWithParam(hql, stuUuid);
	}
	@Override
	public EmployedInfo loadByStuNum(String stunum) {
		String hql ="from EmployedInfo emi where emi.empStuUUid = ?";
		return this.listByhqlWithParam(hql, stunum).get(0);
	}
	@Override
	public List<SelectUtils> listByType(String type) {
		String sql = "SELECT tb.baseCodekey as `value` , "
				+ "tb.keyValue as `name` FROM t_basecode tb WHERE tb.baseCodeType= ?";
		
		return super.listBysqlWithParam(sql, type, SelectUtils.class, false);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpInfoCount> listCountEmpinf(EmpInfoCount ec) {
		Map<String ,Object>  obj = this.getSql2(ec);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
		String sql = obj.get("sql").toString();
		return listBysqlWithalias(sql, alias, EmpInfoCount.class, false);
	}
	private Map<String ,Object> getSql2(EmpInfoCount ec){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = " select "+
				" t.collegeName,"+
				" t.collegeNum,"+
				" sum(t1.ctn1) utn,"+
				" sum(t2.ctn2) atn,"+
				" sum(t3.ctn3) ttn,"+
				" ROUND((sum(t1.ctn1)/sum(t3.ctn3))*100,2) perutn,"+
				" ROUND((sum(t2.ctn2)/sum(t3.ctn3))*100,2) peratn"+
				" from t_student t"+
				" LEFT JOIN"+
				" ("+
				" 	SELECT "+
				" 	 te.empStuUUid,"+
				"    count(1) ctn1 "+
				"    FROM "+
				"    t_empinfo te"+
				"    WHERE"+
				" 	 te.finshStatus = 0"+
				" 	 GROUP BY"+
				" 		te.empStuUUid"+
				" ) t1"+
				" ON"+
				" t.stuUuid in(t1.empStuUUid)"+
				" LEFT JOIN"+
				" ("+
				" 	SELECT "+
				" 	 te.empStuUUid,"+
				"    count(1) ctn2"+
				"    FROM "+
				"    t_empinfo te"+
				"    WHERE"+
				" 	 te.finshStatus = 9"+
				" 	 GROUP BY"+
				" 		te.empStuUUid"+
				" ) t2"+
				" ON"+
				" t.stuUuid in(t2.empStuUUid)"+
				" LEFT JOIN"+
				" ("+
				" 	SELECT "+
				" 	 te.empStuUUid,"+
				"    count(1) ctn3"+
				"    FROM "+
				"    t_empinfo te"+
				" 	 GROUP BY"+
				" 		te.empStuUUid"+
				" ) t3"+
				" ON"+
				" t.stuUuid in(t3.empStuUUid)"+
				" WHERE 1=1 ";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(ec!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(ec.getCollegeName())){
				sbf.append(" and t.collegeName like:collegeName ");
				alias.put("collegeName",StringUtils.gennerateLike(ec.getCollegeName()));
			}
			if(StringUtils.isNotNull(ec.getCollegeNum())){
				sbf.append(" and t.collegeNum like:collegeNum ");
				alias.put("collegeNum",StringUtils.gennerateLike(ec.getCollegeNum()));
			}
		}
		sbf.append(" GROUP BY t.collegeName");
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Pager<EmpInfoCount> findByPagercountEmpinf(EmpInfoCount ec) {
		Map<String ,Object>  obj = this.getSql2(ec);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
		String sql = obj.get("sql").toString();
		return  super.findBysqlWithalias(sql,  alias, EmpInfoCount.class, false);
	}
}
