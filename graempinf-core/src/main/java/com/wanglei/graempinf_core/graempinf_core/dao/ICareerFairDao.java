package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;

/**
 * <p>Title: 招聘会信息的Dao</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月21日
 */
public interface ICareerFairDao extends IBaseDao<CareerFair> {
	/**
	 * <p>Description:添加招聘会信息<p>
	 * @param caf
	 * @author wanglei 2017年3月21日
	 */
	public void addCareeFair(CareerFair caf);
	/**
	 * <p>Description:删除招聘会信息<p>
	 * @param uuids
	 * @author wanglei 2017年3月21日
	 */
	public void deleteCareerFair(String id);
	/**
	 * <p>Description:更新招聘会信息<p>
	 * @param caf
	 * @author wanglei 2017年3月21日
	 */
	public void updateCareerFair(CareerFair caf);
	/**
	 * <p>Description:分页查找招聘会信息<p>
	 * @param caf
	 * @return
	 * @author wanglei 2017年3月21日
	 */
	public Pager<CareerFair> findBypager(CareerFair caf);
	/**
	 * <p>Description:查询所有的招聘会信息<p>
	 * @param caf
	 * @return
	 * @author wanglei 2017年3月21日
	 */
	public List<CareerFair> listCareerFair(CareerFair caf);
	/**
	 * <p>Description:根据id查询<p>
	 * @param uuid
	 * @return
	 * @author wanglei 2017年3月21日
	 */
	public CareerFair loadCareerFairByUUid(String uuid);
	/**
	 * <p>Description:更改发布会装态<p>
	 * @author wanglei 2017年3月24日
	 */
	public void updateCareerFairStatus(String uuid,Integer status);
}
