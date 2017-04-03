package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.CapCafPro;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;

/**
 * <p>Title:招聘会和预约关系dao </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月21日
 */
public interface ICapDao extends IBaseDao<CareerFairAppointment> {
	/**
	 * <p>Description:添加预约信息<p>
	 * @param cap
	 * @author wanglei 2017年3月21日
	 */
	public void addCap(CareerFairAppointment cap);
	/**
	 * <p>Description:更新预约信息<p>
	 * @param cap
	 * @author wanglei 2017年3月21日
	 */
	public void updateCap(CareerFairAppointment cap);
	/**
	 * <p>Description:根据id查询<p>
	 * @param uuid
	 * @author wanglei 2017年3月21日
	 */
	public CareerFairAppointment loadByuuid(String uuid);
	/**
	 * <p>Description:分页查找预约信息<p>
	 * @param caf
	 * @return
	 * @author wanglei 2017年3月21日
	 */
	public Pager<CareerFairAppointment> findBypager(CareerFairAppointment caf);
	/**
	 * <p>Description:返回预约信息<p>
	 * @param caf
	 * @return
	 * @author wanglei 2017年3月21日
	 */
	public List<CareerFairAppointment> listCareerFair(CareerFairAppointment caf);
	/**
	 * <p>Description:，更新预约状态<p>
	 * @param uuid
	 * @author wanglei 2017年3月21日
	 */
	 public void updateStatus(String uuid,Integer status);
	 /**
	  * <p>Description:根据招聘会id查询<p>
	  * @param cfid
	  * @return
	  * @author wanglei 2017年3月24日
	  */
	 public List<CareerFairAppointment> loadByCfid(String cfid);
	 public List<CareerFairAppointment> loadByCfidAndCapid(String cfid ,String Capid);	 
	 /**
	 * <p>Description:查找招聘会预约关系<p>
	 * @param cacap
	 * @return
	 * @author wanglei 2017年4月3日
	 */
	public  Pager<CapCafPro> findCapCapro(CapCafPro cacap);
	public  List<CapCafPro> listCapCapro(CapCafPro cacap);
}
