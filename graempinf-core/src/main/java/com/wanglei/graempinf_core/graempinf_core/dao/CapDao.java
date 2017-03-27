package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import CareerFairAppointment.ICapDao;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;
@Repository("capDao")
public class CapDao extends BaseDao<CareerFairAppointment> implements ICapDao {
	@Override
	public void addCap(CareerFairAppointment cap) {
		super.add(cap);
	}

	@Override
	public void updateCap(CareerFairAppointment cap) {
		super.update(cap);
	}

	@Override
	public void loadByuuid(String uuid) {
		super.load(uuid);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<CareerFairAppointment> findBypager(CareerFairAppointment caf) {
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
	public List<CareerFairAppointment> listCareerFair(CareerFairAppointment caf) {
		Map<String ,Object>  obj = this.getSql(caf);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
		String sql = obj.get("sql").toString();
		return listByhqlWithAlias(sql, alias);
	}
	private Map<String ,Object> getSql (CareerFairAppointment caf){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "from CareerFairAppointment cap where 1=1";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(caf!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(caf.getCareeFairName())){
				sbf.append(" and cap.careeFairName like:careeFairName ");
				alias.put("careeFairName",StringUtils.gennerateLike(caf.getCareeFairName()));
			}if(StringUtils.isNotNull(caf.getCapstuNum())){
				sbf.append(" and cap.capstuNum like:capstuNum ");
				alias.put("capstuNum",StringUtils.gennerateLike(caf.getCapstuNum()));
			}if(StringUtils.isNotNull(caf.getCapAppCode())){
				sbf.append(" and cap.capAppCode like:capAppCode ");
				alias.put("capAppCode",StringUtils.gennerateLike(caf.getCapAppCode()));
			}if(null!=caf.getFinshStatus()){
				sbf.append(" and cap.finshStatus =:finshStatus");
				sbf.append(" and cap.finshStatus =:finshStatus");
				alias.put("finshStatus",caf.getFinshStatus());
			} 
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj ;
	}
	@Override
	public void updateStatus(String uuid,Integer status) {
		String hql = "update CareerFairAppointment cap set cap.finshStatus= ? where cap.capUUid = ?";
		super.updateByHqlWithParams(hql, new Object[]{status,uuid});
	}

	@Override
	public List<CareerFairAppointment> loadByCfid(String cfid) {
		String hql ="from CareerFairAppointment cap where cap.careeFairUuid =?";
		return super.listByhqlWithParam(hql, cfid);
	}

}
