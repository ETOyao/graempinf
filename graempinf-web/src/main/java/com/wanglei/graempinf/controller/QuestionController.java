package com.wanglei.graempinf.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.IQuestionSrevice;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf_core.graempinf_core.model.Question;
import com.wanglei.graempinf_core.graempinf_core.model.User;
@Controller
@RequestMapping("/admin/question")
@AuthClass
public class QuestionController {
	private IQuestionSrevice questionService;
	
	public IQuestionSrevice getQuestionService() {
		return questionService;
	}
	@Inject
	public void setQuestionService(IQuestionSrevice questionService) {
		this.questionService = questionService;
	}
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="questions",method=RequestMethod.GET)
	public String list(Question que, Model model){
		model.addAttribute("que", que);
		model.addAttribute("ques", questionService.findBypager(que));
		return "question/list";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="stuquestions",method=RequestMethod.GET)
	public String listforStudent(Question que, Model model){
		model.addAttribute("que", que);
		que.setStuuuid(userService.getCurentLoginUser().getStuUuid());
		model.addAttribute("ques", questionService.findBypager(que));
		return "question/stuquelist";
	}
	
	private void inIntAdd(Model model){
		User u = userService.getCurentLoginUser();
		model.addAttribute("que", new Question());
		model.addAttribute("stuid",u.getStuUuid());
		model.addAttribute("stunum",u.getUserName());
		model.addAttribute("stuname",u.getUserNickName());
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add( Model model){
		inIntAdd( model);
		return "question/add";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(Question que,BindingResult br,Model model){
		if(br.hasErrors()){
			inIntAdd(model);
			model.addAttribute("que", que);
		}else{
			questionService.add(que);
		}
		return"redirect:/admin/question/stuquestions";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="update/{uuid}",method=RequestMethod.GET)
	public String update(@PathVariable String uuid,Model model){
		model.addAttribute("que", questionService.loadById(uuid));
		return "question/update";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="update/{uuid}",method=RequestMethod.POST)
	public String update(@PathVariable String uuid,Question que,BindingResult br,Model model){
		if(br.hasErrors()){
			model.addAttribute("que", que);
		}else{
			que.setAnswerPerson(userService.getCurentLoginUser().getUserNickName());
			questionService.updateQuestion(que);
		}
		return"redirect:/admin/question/questions";
	}
	@AuthMethod(role="ROLE_TEACHTER,ROLE_STUDENT")
	@RequestMapping(value="/{uuid}",method=RequestMethod.GET)
	public String show(@PathVariable String uuid,Model model){
		model.addAttribute("que", questionService.loadById(uuid));
		return "question/show";
	}
}
