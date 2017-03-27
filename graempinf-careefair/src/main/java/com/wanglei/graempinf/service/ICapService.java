package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;

/**
 * <p>Title:招聘会和预约关系的service </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月24日
 */
public interface ICapService {
/**
 * <p>Description:添加招聘会和预约关系<p>
 * @param cap
 * @author wanglei 2017年3月24日
 */
public void add (CareerFairAppointment cap);
/**
 * <p>Description:修改招聘会和预约关系<p>
 * @param cap
 * @author wanglei 2017年3月24日
 */
public void update(CareerFairAppointment cap);
/**
 * <p>Description:分页查询列表<p>
 * @param cap
 * @return
 * @author wanglei 2017年3月24日
 */
public Pager<CareerFairAppointment> findByPager(CareerFairAppointment cap);
/**
 * <p>Description:列表查询<p>
 * @param cap
 * @return
 * @author wanglei 2017年3月24日
 */
public List<CareerFairAppointment> listCareerFairAppointment(CareerFairAppointment cap);
/**
 * <p>Description:根据Id查找<p>
 * @param id
 * @return
 * @author wanglei 2017年3月24日
 */
public CareerFairAppointment loadByid(String id);

}
