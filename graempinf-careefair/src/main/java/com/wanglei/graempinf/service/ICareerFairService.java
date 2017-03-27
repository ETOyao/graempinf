package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;

public interface ICareerFairService {
/**
 * <p>Description:添加招聘会信息<p>
 * @param cf
 * @author wanglei 2017年3月24日
 */
public void add(CareerFair cf);
/**
 * <p>Description:删除招聘会信息<p>
 * @param id
 * @author wanglei 2017年3月24日
 */
public void delete(String id);
/**
 * <p>Description:更新招会信息<p>
 * @param cf
 * @author wanglei 2017年3月24日
 */
public void update(CareerFair cf);
/**
 * <p>Description:根据id查询<p>
 * @param uuid
 * @return
 * @author wanglei 2017年3月24日
 */
public CareerFair load(String uuid);
/**
 * <p>Description:查询招聘会分页信息<p>
 * @param cf
 * @return
 * @author wanglei 2017年3月24日
 */
public Pager<CareerFair> findByPager(CareerFair cf);
/**
 * <p>Description:查询招聘会列表<p>
 * @param cf
 * @return
 * @author wanglei 2017年3月24日
 */
public List<CareerFair> listCareerFair(CareerFair cf) ;
/**
 * <p>Description:发布招聘会信息<p>
 * @author wanglei 2017年3月24日
 */
public void updateCareerFair(CareerFair cf);
/**
 * <p>Description:取消发布<p>
 * @author wanglei 2017年3月24日
 */
public void updateCareerFair(String uuid);
}
