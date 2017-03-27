package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;

/**
 * <p>Title: 就业信息的service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月27日
 */
public interface IEmpInfService {
	/**
	 * <p>Description:更新就业信息<p>
	 * @param empi
	 * @author wanglei 2017年3月10日
	 */
	public void update(EmployedInfo empi);
	/**
	 * <p>Description:分业查找就业信息<p>
	 * @param empi
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public Pager<EmployedInfo> findBypage(EmployedInfo empi);
	/**
	 * <p>Description:<p>
	 * @param id
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public EmployedInfo loadByuuid(String id);
	/**
	 * <p>Description:返回所有的列表信息<p>
	 * @param empi
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public List<EmployedInfo> list(EmployedInfo empi);
	/**
	 * <p>Description:根据类型获取下来列表<p>
	 * @param type
	 * @return
	 * @author wanglei 2017年3月16日
	 */
	public List<SelectUtils> listByType(String type);
	/**
	 * <p>Description:根据学生id查找就业信息<p>
	 * @param stuuid
	 * @return
	 * @author wanglei 2017年3月19日
	 */
	public EmployedInfo loadBystuid(String stuuid);
	
}
