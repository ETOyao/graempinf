package com.wanglei.graempinf.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.DateUtils;
import com.wanglei.basic.util.ExcelUtiuls;
import com.wanglei.basic.util.JsonUtil;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.ICapService;
import com.wanglei.graempinf.service.ICareerFairService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.CommonWebUtil;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.User;

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
	private ICapService capService;
	public ICapService getCapService() {
		return capService;
	}
	@Inject
	public void setCapService(ICapService capService) {
		this.capService = capService;
	}
	@AuthMethod(role="ROLE_TEACHTER")
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
	@AuthMethod(role="ROLE_TEACHTER,ROLE_STUDENT")
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
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="appcareeFairs",method=RequestMethod.GET)
	public String appcareeFairs(CareerFair cf,Model model){
		model.addAttribute("cf", cf);
		cf.setFinshStatus(9);
		model.addAttribute("cfs", careerFairService.findByPager(cf));
		return "careeFair/applayedlist";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="initCap",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String appcareeFairs(String uuid){
		Map<String,Object> res = new HashMap<>();
		
	    User u = userService.getCurentLoginUser();
		List<CareerFairAppointment> caps = capService.loadByCfidAndCapid(u.getStuUuid(),uuid );
		if(null!=caps&&caps.size()<1){
			//预约编号
			res.put("capCode", this.createCapcode(u.getUserName()));
			//姓名
			res.put("stuName", u.getUserNickName());
			//学号
			res.put("stuNum", u.getUserName());
			//电话
			res.put("attr1", u.getUserPhone());
			//邮箱
			res.put("attr2", u.getUserEmail());
			//学生id
			res.put("capstuUuid", u.getStuUuid());
			JSONObject ja =  JSONObject.fromObject(careerFairService.load(uuid));
			res.put("cf", ja);
			res.put("message","");
		}else{
			res.put("message","你已经预约过该招聘会，不能再预约！");
		}
		return JsonUtil.toJson(res);
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
	
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping("/exportcfinfo")
	public String exPort(CareerFair cf,HttpServletRequest request, HttpServletResponse response){
		 List<CareerFair> cfs = careerFairService.listCareerFair(cf);
		 Workbook wf= ExcelUtiuls.generateExcel(getMapByCareerFair(cfs), "招聘会信息");
		 return CommonWebUtil.wrieExcel(request, response, wf,"招聘会信息.xls");
	 }
	 private List<Map<String,String>> getMapByCareerFair(List<CareerFair> cfs){
		List<Map<String,String>> lms = new ArrayList<Map<String,String>>(); 
		for(CareerFair cf:cfs){
			Map <String,String> stm = new HashMap<String,String>();
			stm.put("状态", cf.getFinshStatus()==null?" ":cf.getFinshStatus()==1?"已发布":"未发布");
			stm.put("招聘会名称", cf.getCareerFairName());
			stm.put("招聘会类型", cf.getCareerFairTypeName());
			stm.put("招聘会地点", cf.getCareerFairAddr());
			stm.put("招聘会举行时间", cf.getCareerFairName());
			stm.put("招聘会发布时间", cf.getApplayCareerFairDate()==null?"":cf.getApplayCareerFairDate().toString());
			stm.put("招聘添加时间", cf.getCreateCareerFairDate()==null ?"" :cf.getCreateCareerFairDate().toString());
			stm.put("添加人", cf.getCareerPerson());
			stm.put("发布人", cf.getApplyPerson());
			stm.put("承办单位", cf.getCareerFairUndertaker());
			lms.add(stm);
		}
		return lms;
	 } 
	 private String createCapcode(String str){
		 if(StringUtils.isNll(str) || (StringUtils.isEmpty(str))){
			throw new GraEmpInfException("发生错误！预约编号生成不成功，请联系管理员！");
		 }
		 //开始
		 String beg = DateUtils.getCurrentSqlDate().toString().replace("-", "");
		 StringBuffer sbf = new StringBuffer(beg);
		 //中间
		 sbf.append(str.substring(str.length()-4, str.length()));
		 //结尾
		 Random ra = new Random();
		 for(int i=0;i<4;i++){
			 int r = ra.nextInt(9);
			 sbf.append(r); 
		 }
		 return sbf.toString();
	 }
}
