package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.CapCafPro;
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
	public CareerFairAppointment loadByuuid(String uuid) {
		return (CareerFairAppointment) super.getSession().get(CareerFairAppointment.class, uuid);

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
			}if(StringUtils.isNotNull(caf.getCapstuUuid())){
				sbf.append(" and cap.capstuUuid =:stuuid ");
				alias.put("stuuid",caf.getCapstuUuid());
			}
			if(StringUtils.isNotNull(caf.getCapAppCode())){
				sbf.append(" and cap.capAppCode like:capAppCode ");
				alias.put("capAppCode",StringUtils.gennerateLike(caf.getCapAppCode()));
			}if(null!=caf.getFinshStatus()&&caf.getFinshStatus()!=-1){
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
	@Override
	public List<CareerFairAppointment> loadByCfidAndCapid(String cfid,String Capid) {
		String hql ="from CareerFairAppointment cap where cap.capstuUuid =? And cap.careeFairUuid =?";
		return super.listByhqlWithParams(hql, new Object []{cfid,Capid});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<CapCafPro> findCapCapro(CapCafPro cacap) {
		Map<String ,Object>  obj = this.getSql2(cacap);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
		String sql = obj.get("sql").toString();
		return  super.findBysqlWithalias(sql,  alias, CapCafPro.class, false);
	}
	private Map<String ,Object> getSql2(CapCafPro cacap){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "SELECT "
				+ "tc.careerFairName,tc.careerFairTypeName,"
				+ "tc.careerFairType,t1.cnt1 ,t2.cnt2 ,"
				+ "t3.cnt3 ,t4.cnt4 ,t5.cnt5 "
				+"from "
				+ " t_careefair tc "
					+"  LEFT JOIN "
					+"("
					+"	SELECT "
					+"	count(1) cnt1 ,tca1.careeFairUuid"
					+"	FROM "
					+"	t_careefairappiontment tca1"
					+"	WHERE"
					+"	tca1.finshStatus = 1"
					+"   GROUP BY"
					+"   tca1.careeFairUuid"
					+") t1"
					+"   ON"
					+" tc.careerFairUuid in(t1.careeFairUuid)"
					+" LEFT JOIN"
					+"("
					+"	SELECT "
					+"	count(1) cnt2 ,tca1.careeFairUuid"
					+"	FROM "
					+"	t_careefairappiontment tca1"
					+"	WHERE"
					+"	tca1.finshStatus = 2"
					+" GROUP BY"
					+"   tca1.careeFairUuid"
					+") t2"
					+" on"
					+" tc.careerFairUuid in(t2.careeFairUuid)"
					+" LEFT JOIN"
					+"("
					+"	SELECT "
					+"	count(1) cnt3 ,tca1.careeFairUuid"
					+"	FROM "
					+"	t_careefairappiontment tca1"
					+"	WHERE"
					+"	tca1.finshStatus = 3"
					+" GROUP BY"
					+"   tca1.careeFairUuid"
					+") t3"
					+" ON"
					+" tc.careerFairUuid in(t3.careeFairUuid)"
					+"  LEFT JOIN"
					+"("
					+"	SELECT "
					+"	count(1) cnt4 ,tca1.careeFairUuid"
					+"	FROM "
					+"	t_careefairappiontment tca1"
					+"	WHERE"
					+"	tca1.finshStatus = 0"
					+" GROUP BY"
					+"   tca1.careeFairUuid"
					+") t4"
					+" ON"
					+" tc.careerFairUuid in(t4.careeFairUuid)"
					+" LEFT JOIN"
					+"("
					+"	SELECT "
					+"	count(1) cnt5 ,tca1.careeFairUuid"
					+"	FROM "
					+"	t_careefairappiontment tca1"
					+" GROUP BY"
					+"   tca1.careeFairUuid"
					+") t5"
					+" ON"
					+" tc.careerFairUuid in(t5.careeFairUuid)"
					+" WHERE"
					+" tc.finshStatus =1";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(cacap!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(cacap.getCareerFairName())){
				sbf.append(" and tc.careerFairName like:careeFairName ");
				alias.put("careeFairName",StringUtils.gennerateLike(cacap.getCareerFairName()));
			}if(cacap.getCareerFairType()!=null){
				sbf.append(" and tc.careerFairType =:careerFairType ");
				alias.put("careerFairType",cacap.getCareerFairType());
			}
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CapCafPro> listCapCapro(CapCafPro cacap) {
		Map<String ,Object>  obj = this.getSql2(cacap);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
		String sql = obj.get("sql").toString();
		return listBysqlWithalias(sql, alias, CapCafPro.class, false);
	}
		
}
