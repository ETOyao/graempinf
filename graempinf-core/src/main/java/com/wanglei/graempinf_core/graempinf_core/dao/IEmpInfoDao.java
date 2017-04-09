package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.EmpInfoCount;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;

/**
 * <p>Title:就业信息Dao </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月26日
 */
public interface IEmpInfoDao extends IBaseDao<EmployedInfo> {
	/**
	 * <p>Description:就业信息添加<p>
	 * @param empi
	 * @author WangLei 2017年2月26日
	 * @return 
	 */
	public EmployedInfo add(EmployedInfo empi);
	/**
	 * <p>Description:删除就业信息<p>
	 * @param uuid
	 * @author WangLei 2017年2月26日
	 */
	public void delete(String uuid);
	/**
	 * <p>Description:修改就业信息<p>
	 * @param empi
	 * @author WangLei 2017年2月26日
	 */
	public void upate(EmployedInfo empi);
	/**
	 * <p>Description:根据ID查询就业信息<p>
	 * @param uuid
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public EmployedInfo lodbyId(String uuid);
	/**
	 * <p>Description:分页查询就业信息<p>
	 * @param empInf
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public Pager<EmployedInfo> findByPager(EmployedInfo  empInf);
	/**
	 * <p>Description:查找就业信息<p>
	 * @param empInf
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public List<EmployedInfo > listEmpinf(EmployedInfo empInf);
	/**
	 * <p>Description:<p>
	 * @param stuUuid
	 * @author WangLei 2017年2月26日
	 */
	public void deleteByStuUuid(String stuUuid);
	/**
	 * <p>Description:根据学号查询<p>
	 * @param stunum
	 * @return
	 * @author wanglei 2017年3月11日
	 */
	public EmployedInfo loadByStuNum(String stunum);
	/**
	 * <p>Description:根据类型获取下来列表<p>
	 * @param type
	 * @return
	 * @author wanglei 2017年3月16日
	 */
	public List<SelectUtils> listByType(String type);
	/**
	 * <p>Description:就业率统计<p>
	 * @return
	 * @author wanglei 2017年4月9日
	 */
	public List<EmpInfoCount> listCountEmpinf(EmpInfoCount ec);
	/**
	 * <p>Description:分页查找<p>
	 * @param ec
	 * @return
	 * @author wanglei 2017年4月9日
	 */
	public Pager<EmpInfoCount> findByPagercountEmpinf(EmpInfoCount ec);
	
}
