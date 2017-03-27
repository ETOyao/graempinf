package com.wanglei.graempinf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanglei.basic.util.ExcelUtiuls;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.ISourceStudnetService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.CommonWebUtil;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.SourceStudent;

@Controller
@RequestMapping("admin/sst")
@AuthClass
public class SourceStudentController {
	Logger log = Logger.getLogger(SourceStudentController.class);
	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	private ISourceStudnetService sourceStudentService;
	
	public ISourceStudnetService getSourceStudentService() {
		return sourceStudentService;
	}
	@Inject
	public void setSourceStudentService(ISourceStudnetService sourceStudentService) {
		this.sourceStudentService = sourceStudentService;
	}
	private void inintAdd(Model model){
		model.addAttribute("isLowpro", convertToMap("isLowpro"));
		model.addAttribute("souType", convertToMap("souType"));
		model.addAttribute("sst",new SourceStudent());
	}
	private Map<Integer,String> convertToMap(String type){
		Map <Integer,String> remap = new HashMap<Integer, String>();
		if("isLowpro".equals(type)){
			remap.put(BaseCodeEnum.IS_LOW_PRO.getIndex(),BaseCodeEnum.IS_LOW_PRO.getName());
			remap.put(BaseCodeEnum.NO_LOW_PRO.getIndex(),BaseCodeEnum.NO_LOW_PRO.getName());
		}if("souType".equals(type)){
	      remap.put(BaseCodeEnum.SOURCE_TYPE_DEFAULT.getIndex(),BaseCodeEnum.SOURCE_TYPE_DEFAULT.getName());
	      remap.put(BaseCodeEnum.SOURCE_TYPE_CITY.getIndex(),BaseCodeEnum.SOURCE_TYPE_CITY.getName());
	      remap.put(BaseCodeEnum.SOURCE_TYPE_COUTRY.getIndex(),BaseCodeEnum.SOURCE_TYPE_COUTRY.getName());
		}
		return remap;
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="ssts",method=RequestMethod.GET)
	public String list (SourceStudent sst,Model model){
		model.addAttribute("sst",sst);
		model.addAttribute("ssts", sourceStudentService.findByPager(sst));
		return "sst/list";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{souUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String souUuid ,Model model ){
		inintAdd(model);
		model.addAttribute("sst", sourceStudentService.loadById(souUuid));
		return "sst/update";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/updateSelf",method=RequestMethod.GET)
	public String updateSelf(Model model ){
		inintAdd(model);
		String stuuuid =userService.getCurentLoginUser().getStuUuid();
		SourceStudent sst =sourceStudentService.loadByStunum(stuuuid);
		model.addAttribute("sst", sst);
		if(sst.getFinshStatus()==9){
			return "sst/show";
		}
		return "sst/updateSelf";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{souUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String souUuid ,@Valid SourceStudent sst, BindingResult br,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			return "sst/update";
		}
		SourceStudent temsst = sourceStudentService.loadById(souUuid);
		if(null!=temsst){
			sourceStudentService.update(sst);
		}else{
			log.error("更新生源地信息错误，生源地信息不存在！");
			throw new GraEmpInfException("更新生源地信息错误，生源地信息不存在！");	
		}
		return "redirect:/admin/sst/ssts";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/updateSelf/{souUuid}",method=RequestMethod.POST)
	public String updateSelf(@PathVariable String souUuid ,@Valid SourceStudent sst, BindingResult br,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			model.addAttribute("sst", sst);
			return "sst/updateSelf";
		}
		SourceStudent temsst = sourceStudentService.loadById(souUuid);
		if(null!=temsst ){
			sourceStudentService.update(sst);
		}else{
			log.error("更新生源地信息错误，生源地信息不存在！");
			throw new GraEmpInfException("更新生源地信息错误，生源地信息不存在！");	
		}
		if(sst.getFinshStatus()==9){
			model.addAttribute("sst", sst);
			return "sst/show";
		}
		inintAdd(model);
		model.addAttribute("sst", sst);
		return "sst/updateSelf";
	}
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="/{souUuid}",method=RequestMethod.GET)
	public String load(@PathVariable String souUuid,Model model){
		model.addAttribute("sst", sourceStudentService.loadById(souUuid));
		return "sst/show";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	 @RequestMapping("/exportsst")
		public String exPort(SourceStudent sst,HttpServletRequest request, HttpServletResponse response){
			 List<SourceStudent> ssts = sourceStudentService.list(sst);
			 Workbook wf= ExcelUtiuls.generateExcel(getMapBysst(ssts), "生源地信息");
			 return CommonWebUtil.wrieExcel(request, response, wf,"生源地信息.xls");
		 }
		 /**
		 * <p>Description:根据实体类获得导出map<p>
		 * @param empis
		 * @return
		 * @author wanglei 2017年3月10日
		 */
		private List<Map<String,String>> getMapBysst(List<SourceStudent> ssts){
			List<Map<String,String>> lms = new ArrayList<Map<String,String>>(); 
			for(SourceStudent sst:ssts){
				Map <String,String> stm = new HashMap<String,String>();
				stm.put("考试号", sst.getSouExamNum());
				stm.put("学号", sst.getSouStuNum());
				stm.put("身份证号", sst.getSouIdcardNum());
				stm.put("姓名", sst.getSouName());
				stm.put("生源地",sst.getSouAddr());
				stm.put("家庭住址",sst.getSouHomeAddr());
				Integer type = sst.getSouSouceType();
				if(null!=type){
					stm.put("生源地类型",type==1?"城市":"农村");
				}else{
					stm.put("生源地类型","");
				}
				Integer lo = sst.getSouIsLowPro();
				if(null!=lo){
					stm.put("是否低保",lo==1?"是":"否");
				}else{
					stm.put("是否低保","");
				}
				lms.add(stm);
			}
			return lms;
		 } 
}
