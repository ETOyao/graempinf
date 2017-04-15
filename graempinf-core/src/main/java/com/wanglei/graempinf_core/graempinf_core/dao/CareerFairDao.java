package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;
@Repository("careerFairDao")
public class CareerFairDao extends BaseDao<CareerFair> implements ICareerFairDao {

	@Override
	public void addCareeFair(CareerFair caf) {
		super.add(caf);
	}

	@Override
	public void deleteCareerFair(String id) {
			super.delete(id);
	}

	@Override
	public void updateCareerFair(CareerFair caf) {
		super.update(caf);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<CareerFair> findBypager(CareerFair caf) {
		Map<String ,Object>  obj = this.getSql(caf);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String hql = obj.get("sql").toString();
		return findByHqlWithalias(hql, alias);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CareerFair> listCareerFair(CareerFair caf) {
		Map<String ,Object>  obj = this.getSql(caf);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String sql = obj.get("sql").toString();
		return listByhqlWithAlias(sql, alias);
	}
	private Map<String ,Object> getSql (CareerFair caf){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "from CareerFair cf where 1=1";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(caf!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(caf.getCareerFairAddr() )){
				sbf.append(" and cf.careerFairAddr like:careerFairAddr ");
				alias.put("careerFairAddr",StringUtils.gennerateLike(caf.getCareerFairAddr()));
			}if(StringUtils.isNotNull(caf.getCareerFairName())){
				sbf.append(" and cf.careerFairName like:careerFairName");
				alias.put("careerFairName",StringUtils.gennerateLike(caf.getCareerFairName()));
			}
			if(StringUtils.isNotNull(caf.getCareerFairUndertaker())){
				sbf.append(" and cf.careerFairUndertaker like:careerFairUndertaker");
				alias.put("careerFairUndertaker",StringUtils.gennerateLike(caf.getCareerFairUndertaker()));
			} if(null!=caf.getCareerFairType()){
				sbf.append(" and cf.careerFairType =:careerFairType");
				alias.put("careerFairType",caf.getCareerFairType());
			} 
			 if(null!=caf.getAttr1()){
					sbf.append(" and cf.attr1 =:adduid");
					alias.put("adduid",caf.getAttr1());
			} 
			if(null!=caf.getCareerFairDate()){
				sbf.append(" and cf.careerFairDate =:careerFairDate");
				alias.put("careerFairDate",caf.getCareerFairDate());
			} 
			if(null!=caf.getFinshStatus() && caf.getFinshStatus()!=-1&&caf.getFinshStatus()!=9){
				sbf.append(" and cf.finshStatus =:finshStatus");
				alias.put("finshStatus",caf.getFinshStatus());
			} 
			if(null!=caf.getFinshStatus() &&caf.getFinshStatus()==9){
				sbf.append(" and cf.finshStatus>:finshStatus");
				alias.put("finshStatus",0);
			} 
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj ;
	}
	@Override
	public CareerFair loadCareerFairByUUid(String uuid) {
		return (CareerFair)super.getSession().get(CareerFair.class, uuid);
	}

	@Override
	public void updateCareerFairStatus(String uuid,Integer status) {
		String hql ="update CareerFair cf set cf.finshStatus= ? where cf.careerFairUuid = ?";
		super.updateByHqlWithParams(hql, new Object[]{status,uuid});
	}

}
