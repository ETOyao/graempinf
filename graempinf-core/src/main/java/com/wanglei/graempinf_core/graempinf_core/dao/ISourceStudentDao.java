package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;

/**
 * <p>Title:生源地信息的Dao </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月26日
 */
public interface ISourceStudentDao extends IBaseDao<SourceStudent> {
	/**
	 * <p>Description: 生源地信息添加<p>
	 * @param soustu
	 * @return
	 * @author WangLei 2017年2月12日
	 */

	public SourceStudent add(SourceStudent soustu);
	/**
	 * <p>Description:生源地信息删除<p>
	 * @param uuid
	 * @author WangLei 2017年2月26日
	 */
	public void delte(String uuid);
	/**
	 * <p>Description:根据学生id删除生源地信息<p>
	 * @param stuid
	 * @author WangLei 2017年2月26日
	 */
	public void deleteBystuid(String stuid);
	/**
	 * <p>Description:更新生源地信息<p>
	 * @param stuid
	 * @author WangLei 2017年2月26日
	 */
	public void update (SourceStudent soustu);
	
	/**
	 * <p>Description:分页查询生源地信息<p>
	 * @param soustu
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public Pager<SourceStudent> findByPager(SourceStudent soustu);
	/**
	 * <p>Description:不分页查询生源地信息<p>
	 * @param soustu
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public List<SourceStudent> listSourceStduent(SourceStudent soustu);
	/**
	 * <p>Description: 根据id 查询生源地信息<p>
	 * @param uuid
	 * @return
	 * @author WangLei 2017年2月26日
	 */
	public SourceStudent loadById(String uuid);
	/**
	 * <p>Description:根据学号查找<p>
	 * @return
	 * @author wanglei 2017年3月11日
	 */
	public SourceStudent loadByStuNum(String stuNum);
}
