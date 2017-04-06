package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf_core.graempinf_core.model.Question;
@Repository("questionDao")
public class QuestionDao extends BaseDao<Question> implements IQuestionDao {

	@Override
	public Question add(Question t) {
		return super.add(t);
	}

	@Override
	public void update(Question t) {
		super.update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Question> findByPager(Question que) {
		Map<String ,Object>  obj = this.getSql(que);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String hql = obj.get("sql").toString();
		return super.findByHqlWithalias(hql, alias);
	}

	@SuppressWarnings({  "unchecked" })
	@Override
	public List<Question> listBypager(Question que) {
		Map<String ,Object>  obj = this.getSql(que);
		Map<String,Object> alias = null;
		if(null!=obj.get("alias")){
			alias=(Map<String,Object>)obj.get("alias") ;
		}
				
		String hql = obj.get("sql").toString();
		return super.listByhqlWithAlias(hql, alias);
	}
	private Map<String ,Object> getSql (Question que){
		Map<String ,Object> reobj = new HashMap <String, Object>();
		StringBuffer sbf = new StringBuffer();
		String sql = "from Question que where 1=1";
		sbf.append(sql);
		Map<String, Object> alias = null;
		if(que!=null){
			alias=new HashMap<String, Object>();
			if(StringUtils.isNotNull(que.getQuestionContent())){
				sbf.append(" and que.questionContent like:questionContent ");
				alias.put("questionContent",StringUtils.gennerateLike(que.getQuestionContent()));
			}if(StringUtils.isNotNull(que.getAnswerPerson())){
				sbf.append(" and que.answerPerson like:answerPerson ");
				alias.put("answerPerson",StringUtils.gennerateLike(que.getAnswerPerson()));
			}
			if(StringUtils.isNotNull(que.getStuName())){
				sbf.append(" and que.stuName like:stuName ");
				alias.put("stuName",StringUtils.gennerateLike(que.getStuName()));
			}
			if(StringUtils.isNotNull(que.getStunum())){
				sbf.append(" and que.stunum like:stunum ");
				alias.put("stunum",StringUtils.gennerateLike(que.getStunum()));
			}
			if(StringUtils.isNotNull(que.getStuuuid())){
				sbf.append(" and que.stuuuid =:stuuuid ");
				alias.put("stuuuid",que.getStuuuid());
			}
			if(null!=que.getFinshStatus() && que.getFinshStatus()!=-1){
				sbf.append(" and que.finshStatus =:finshState");
				alias.put("finshState",que.getFinshStatus());
			} 
		}
		reobj.put("sql", sbf.toString());
		reobj.put("alias", alias);
		return reobj ;
	}
	@Override
	public Question getByUuid(String uuid) {
		return (Question)super.getSession().get(Question.class, uuid);
	}

}
