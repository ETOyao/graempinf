package com.wanglei.graempinf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanglei.basic.util.DateUtils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.ICareerFairService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;

@Controller
@RequestMapping("/admin/careeFair")
@AuthClass
public class CareerFairController {
	private ICareerFairService careerFairService;

	public ICareerFairService getCareerFairService() {
		return careerFairService;
	}
	@Inject
	public void setCareerFairService(ICareerFairService careerFairService) {
		this.careerFairService = careerFairService;
	}
	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="careeFairs",method=RequestMethod.GET)
	public String careeFairs(CareerFair cf,Model model){
		model.addAttribute("cf", cf);
		model.addAttribute("cfs", careerFairService.findByPager(cf));
		return "careeFair/list";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		inintAdd(model);
		return "careeFair/add";
	}
	private void inintAdd(Model model){
		model.addAttribute("cf", new CareerFair());
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CareerFair cf ,BindingResult br,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			return"careeFair/add";
		}
		cf.setCreateCareerFairDate(DateUtils.getCurrentTimestamp());
		cf.setFinshStatus(0);
		cf.setCareerPerson(userService.getCurentLoginUser().getUserNickName());
		careerFairService.add(cf);
		return "redirect:/admin/careeFair/careeFairs";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/delete/{uuid}",method=RequestMethod.GET)
	public String delete(@PathVariable String uuid){
		careerFairService.delete(uuid);
		return "redirect:/admin/careeFair/careeFairs";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{uuid}",method=RequestMethod.GET)
	public String update(@PathVariable String uuid ,CareerFair cf,Model model){
		model.addAttribute("cf", careerFairService.load(uuid));
		return "careeFair/update";
	}
	
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{uuid}",method=RequestMethod.POST)
	public String update(@PathVariable String uuid ,CareerFair cf,BindingResult br,Model model){
			if(br.hasErrors()){
				model.addAttribute("cf", cf);
				return "careeFair/update";
			}
			CareerFair temcf = careerFairService.load(uuid);
			if(null!=temcf){
				careerFairService.update(cf);
			}else{
				throw new GraEmpInfException("更新的招聘会信息不存在！更新错误");	
			}
			return "redirect:/admin/careeFair/careeFairs";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/{uuid}",method=RequestMethod.GET)
	public String load(@PathVariable String uuid ,Model model){
		model.addAttribute("cf", careerFairService.load(uuid));
		return "careeFair/show";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/apply/{uuid}",method=RequestMethod.GET)
	public String apply(@PathVariable String uuid){
		CareerFair cf = careerFairService.load(uuid);
		cf.setApplayCareerFairDate(DateUtils.getCurrentTimestamp());
		cf.setFinshStatus(1);
		cf.setApplyPerson(userService.getCurentLoginUser().getUserNickName());
		careerFairService.updateCareerFairApply(cf);
		return "redirect:/admin/careeFair/careeFairs";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/cancel/{uuid}",method=RequestMethod.GET)
	public String cancel(@PathVariable String uuid){
		CareerFair cf = careerFairService.load(uuid);
		cf.setApplayCareerFairDate(null);
		cf.setApplyPerson(null);
		cf.setFinshStatus(0);
		careerFairService.updateCareerFairCancel(cf);
		return "redirect:/admin/careeFair/careeFairs";
	}
	/**
	 * <p>Description:去掉日期类型校验<p>
	 * @param binder
	 * @author WangLei 2017年2月15日
	 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	 dateFormat.setLenient(false);  
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}  
}
