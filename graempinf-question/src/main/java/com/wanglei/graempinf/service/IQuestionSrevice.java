package com.wanglei.graempinf.service;

import java.util.List;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.graempinf_core.graempinf_core.model.Question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年4月4日
 */
public interface IQuestionSrevice {
	/**
	 * <p>Description:添加问题<p>
	 * @param que
	 * @author wanglei 2017年4月4日
	 */
	public void add(Question que);
	/**
	 * <p>Description:更新问题<p>
	 * @param que
	 * @author wanglei 2017年4月4日
	 */
	public void updateQuestion (Question que);
	/**
	 * <p>Description:分页查找<p>
	 * @param que
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public  Pager<Question> findBypager(Question que);
	/**
	 * <p>Description:查询列表<p>
	 * @param que
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public List<Question> listQuesiotn(Question que);
	/**
	 * <p>Description:根据id查找<p>
	 * @param id
	 * @return
	 * @author wanglei 2017年4月4日
	 */
	public Question loadById(String id);
}
