package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;
@Repository("sourceStudentDao")
public class SourceStudnetDao extends BaseDao<SourceStudent> implements ISourceStudentDao {

	@Override
	public SourceStudent add(SourceStudent soustu) {
		return super.add(soustu);
	}

	@Override
	public void delte(String uuid) {
		super.delete(uuid);
	}

	@Override
	public void deleteBystuid(String stuid) {
		String hql = "delete from SourceStudent sst  where sst.souStuUUid = ?";
		super.updateByHqlWithParam(hql, stuid);
	}

	@Override
	public void update(SourceStudent soustu) {
		super.update(soustu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<SourceStudent> findByPager(SourceStudent soustu) {
		Map<String ,Object>  obj = this.getSql(soustu);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return findByHqlWithalias(sql, alias);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SourceStudent> listSourceStduent(SourceStudent soustu) {
		Map<String ,Object>  obj = this.getSql(soustu);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return listByhqlWithAlias(sql, alias);
	}
	/**
	 * <p>Description:获取查询sql<p>
	 * @param soustu
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	private Map<String ,Object> getSql (SourceStudent sst){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "select new SourceStudent (souExamNum,souStuNum,"
				+ "souIdcardNum,souName,"
				+ "souAddr,souHomeAddr,"
				+ "souSouceType,souUuid,finshStatus,souIsLowPro)"+
			"from"+
				" SourceStudent sst"+
			" where 1=1";
			sbf.append(sql);
		Map<String, Object> alias = null;
		if(sst!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(sst.getSouExamNum() )){
				sbf.append(" and sst.souExamNum like:souExamNum");
				alias.put("souExamNum",StringUtils.gennerateLike(sst.getSouExamNum()));
			}if(StringUtils.isNotNull(sst.getSouStuNum())){
				sbf.append(" and sst.souStuNum like:souStuNum ");
				alias.put("souStuNum",StringUtils.gennerateLike(sst.getSouStuNum()));
			}if(StringUtils.isNotNull(sst.getSouIdcardNum())){
				sbf.append(" and sst.souIdcardNum like:souIdcardNum ");
				alias.put("souIdcardNum",StringUtils.gennerateLike(sst.getSouIdcardNum()));
			}if(StringUtils.isNotNull(sst.getSouName())){
				sbf.append(" and sst.souName like:souName ");
				alias.put("souName",StringUtils.gennerateLike(sst.getSouName()));
			}if(StringUtils.isNotNull(sst.getSouAddr())){
				sbf.append(" and sst.souAddr like:souAddr ");
				alias.put("souAddr",StringUtils.gennerateLike(sst.getSouAddr()));
			}if(StringUtils.isNotNull(sst.getSouHomeAddr())){
				sbf.append(" and sst.souHomeAddr like:souHomeAddr ");
				alias.put("souHomeAddr",StringUtils.gennerateLike(sst.getSouHomeAddr()));
			}if(null!=sst.getFinshStatus()){
				if(sst.getFinshStatus()==0 ||sst.getFinshStatus()==9){
				sbf.append(" and sst.finshStatus =:finshStatus");
				sbf.append(" and sst.finshStatus =:finshStatus");
				alias.put("finshStatus",sst.getFinshStatus());
				}
			}if(null!=sst.getSouSouceType()){
				if(sst.getSouSouceType()!=0){
				sbf.append(" and sst.souSouceType =:souSouceType");
				sbf.append(" and sst.souSouceType =:souSouceType");
				alias.put("souSouceType",sst.getSouSouceType());
			}
				
		   }
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj;
	}
	@Override
	public SourceStudent loadById(String uuid) {
		return super.load(uuid);
	}

	@Override
	public SourceStudent loadByStuNum(String stuNum) {
		String hql = "from SourceStudent sst where sst.souStuUUid = ?";
		return super.listByhqlWithParam(hql, stuNum).get(0);
	}


}
