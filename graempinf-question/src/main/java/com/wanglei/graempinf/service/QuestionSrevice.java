package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.DateUtils;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.dao.IQuestionDao;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Question;

@Service("questionService")
public class QuestionSrevice implements IQuestionSrevice{
	private IQuestionDao questionDao;
	
	public IQuestionDao getQuestionDao() {
		return questionDao;
	}
	@Inject
	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public void add(Question que) {
		if(null!=que){
			que.setCreateTime(DateUtils.getCurrentTimestamp());
			que.setFinshStatus(BaseCodeEnum.QUESTION_ANSWER_NO.getIndex());
			questionDao.add(que);
		}else{
			throw new GraEmpInfException("发生系统错误！请联系管理员！");
		}
	}


	@Override
	public void updateQuestion(Question que) {
		if(null!=que){
			que.setAnswertime(DateUtils.getCurrentTimestamp());
			que.setFinshStatus(BaseCodeEnum.QUESTION_ANSWER_YES.getIndex());
			questionDao.update(que);
		}else{
			throw new GraEmpInfException("发生系统错误！请联系管理员！");
		}
	}

	@Override
	public Pager<Question> findBypager(Question que) {
		return questionDao.findByPager(que);
	}

	@Override
	public List<Question> listQuesiotn(Question que) {
		return questionDao.listBypager(que);
	}

	@Override
	public Question loadById(String id) {
		return questionDao.getByUuid(id);
	}

}
