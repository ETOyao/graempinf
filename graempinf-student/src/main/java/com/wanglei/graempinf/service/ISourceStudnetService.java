package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;

/**
 * <p>Title: 生源地信息的service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月27日
 */
public interface ISourceStudnetService {
	/**
	 * <p>Description:更新生源地信息<p>
	 * @param sst
	 * @author wanglei 2017年3月10日
	 */
	public void update(SourceStudent sst);
	/**
	 * <p>Description:分页查找<p>
	 * @param sst
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public Pager<SourceStudent> findByPager(SourceStudent sst);
	/**
	 * <p>Description:列表查询<p>
	 * @param sst
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public List<SourceStudent> list(SourceStudent sst);
	/**
	 * <p>Description:根据id查找<p>
	 * @param id
	 * @return
	 * @author wanglei 2017年3月10日
	 */
	public SourceStudent loadById(String id);
	/**
	 * <p>Description:<p>
	 * @return
	 * @author wanglei 2017年3月19日
	 */
	public SourceStudent loadByStunum(String stuNum);
	
}
