package com.wanglei.graempinf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.ExcelUtiuls;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.IEmpInfService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.CommonWebUtil;
import com.wanglei.graempinf_core.graempinf_core.model.EmployedInfo;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;

@Controller
@RequestMapping("admin/empinfo")
@AuthClass
public class EmpInfoController {
	Logger log = Logger.getLogger(EmpInfoController.class);
	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	private IEmpInfService empInfService;
	public IEmpInfService getEmpInfService() {
		return empInfService;
	}
	@Inject
	public void setEmpInfService(IEmpInfService empInfService) {
		this.empInfService = empInfService;
	}
	private void inIntAdd(Model model){
		model.addAttribute("empinf",new EmployedInfo());
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="empinfs",method = RequestMethod.GET)
	public String list(Model model,EmployedInfo empinf){
		model.addAttribute("empinf", empinf);
		model.addAttribute("empinfs", empInfService.findBypage(empinf));
		return "empinf/list";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{empUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String empUuid,Model model ){
		model.addAttribute("empinf", empInfService.loadByuuid(empUuid));
		return "empinf/update";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/updateSelf",method=RequestMethod.GET)
	public String updateSelf(Model model ){
		String stuuuid =userService.getCurentLoginUser().getStuUuid();
		EmployedInfo empi = empInfService.loadBystuid(stuuuid);
		model.addAttribute("empinf",empi );
		if(empi.getFinshStatus()==9){
			return "empinf/show";
		}
		return "empinf/updateSelf";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{empUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String empUuid,@Valid EmployedInfo empinf, BindingResult br,Model model){
		if(br.hasErrors()){
			this.inIntAdd(model);
			model.addAttribute("empinf",empinf);
			return "empinf/updateSelf";
		}
		EmployedInfo temempi = empInfService.loadByuuid(empUuid);
		if(null!=temempi){
			empInfService.update(empinf);
		}else{
			log.error("就业信息错误，就业信息不存在！");
			throw new GraEmpInfException("就业信息错误更新错误！就业信息不存在！");	
		}
		return "redirect:/admin/empinfo/empinfs";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/updateSelf/{empUuid}",method=RequestMethod.POST)
	public String updateSelf(@PathVariable String empUuid,@Valid EmployedInfo empinf, BindingResult br,Model model){
		if(br.hasErrors()){
			this.inIntAdd(model);
			model.addAttribute("empinf",empinf);
			return "empinf/updateSelf";
		}
		EmployedInfo temempi = empInfService.loadByuuid(empUuid);
		if(null!=temempi){
			empInfService.update(empinf);
		}else{
			log.error("就业信息错误，就业信息不存在！");
			throw new GraEmpInfException("就业信息错误更新错误！就业信息不存在！");	
		}
		model.addAttribute("empinf",empinf);
		if(empinf.getFinshStatus()==9){
			return "empinf/show";
		}
		return "empinf/updateSelf";
	}
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="/{empUuid}",method=RequestMethod.GET)
	public String show(@PathVariable String empUuid,Model model){
		model.addAttribute("empinf", empInfService.loadByuuid(empUuid));
		return "empinf/show";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	 @RequestMapping("/exportempinfo")
		public String exPort(EmployedInfo empi,HttpServletRequest request, HttpServletResponse response){
			 List<EmployedInfo> empis = empInfService.list(empi);
			 Workbook wf= ExcelUtiuls.generateExcel(getMapByEmpinf(empis), "就业信息");
			 return CommonWebUtil.wrieExcel(request, response, wf,"就业信息.xls");
		 }
		 /**
		 * <p>Description:根据实体类获得导出map<p>
		 * @param empis
		 * @return
		 * @author wanglei 2017年3月10日
		 */
		private List<Map<String,String>> getMapByEmpinf(List<EmployedInfo> empis){
			List<Map<String,String>> lms = new ArrayList<Map<String,String>>(); 
			for(EmployedInfo empi:empis){
				Map <String,String> stm = new HashMap<String,String>();
				stm.put("学号", empi.getEmpStuNum());
				stm.put("准考证号", empi.getEmpExaNum());
				stm.put("姓名", empi.getEmpName());
				stm.put("就业协议编号", empi.getEmpAgreementNum());
				stm.put("就业单位名称", empi.getEmpUnitName());
				stm.put("职位类别", empi.getEmpWorkTypeName());
				stm.put("就业单位性质", empi.getEmpUnitStyleName());
				stm.put("毕业去向", empi.getEmpDirectionName());
				Integer finsh = empi.getFinshStatus();
				if(null!=finsh){
					stm.put("状态",finsh==9?"已完善":"未完善" );
				}else{
					stm.put("状态","");
				}
				
				lms.add(stm);
			}
			return lms;
		 } 
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
    @RequestMapping(value="/getSelect/{type}",method=RequestMethod.GET)
    @ResponseBody
	public List<SelectUtils> getSelect(@PathVariable String type){
		return empInfService.listByType(type);
	}
}
