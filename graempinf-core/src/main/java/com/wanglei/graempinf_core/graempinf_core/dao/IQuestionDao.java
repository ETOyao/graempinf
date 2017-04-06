package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.List;

import com.wanglei.basic.hibernate.dao.IBaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Question;

/**
 * <p>Title: 问题反馈的Dao</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年4月4日
 */
public interface IQuestionDao extends IBaseDao<Question> {
	/**
	 * <p>Description:分页查找<p>
	 * @param que
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public Pager<Question> findByPager(Question que);
	/**
	 * <p>Description:查询列表<p>
	 * @param que
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public List<Question> listBypager(Question que);
	/**
	 * <p>Description:根据id查询<p>
	 * @param uuid
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public Question getByUuid(String uuid);
}
