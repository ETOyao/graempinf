package com.wanglei.graempinf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.ExcelUtiuls;
import com.wanglei.basic.util.JsonUtil;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.ICapService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.CommonWebUtil;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.model.CapCafPro;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;
@Controller
@RequestMapping("/admin/cap")
@AuthClass
public class CapController {
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
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="addCap",method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public @ResponseBody String add(CareerFairAppointment cap){
		Map<String,Object> res = new HashMap<>();
		try {
			capService.add(cap);
			res.put("res", "success");
		} catch (Exception e) {
			e.printStackTrace();
			res.put("res", "error");
		}
		return JsonUtil.toJson(res).toString();
	}	
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="caps",method=RequestMethod.GET)	
	public String List(CareerFairAppointment cap, Model model){	
		model.addAttribute("cap", cap);
		cap.setCapstuUuid(userService.getCurentLoginUser().getStuUuid());
		model.addAttribute("caps", capService.findByPager(cap));
		return "cap/list";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/{uuid}",method=RequestMethod.GET)	
	public String load(@PathVariable String uuid, Model model){	
		model.addAttribute("cap",capService.loadByid(uuid));
		return "cap/show";
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="updateEnter/{uuid}",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")	
	public  @ResponseBody String updateEnter(@PathVariable String uuid,String advic , Model model){	
		Map<String,Object> res = new HashMap<>();
		CareerFairAppointment cap =capService.loadByid(uuid);
		cap.setCapAdvice(advic);
		capService.updateEnter(cap);
		CareerFairAppointment cap2 =capService.loadByid(uuid);
		if(cap2.getFinshStatus()==BaseCodeEnum.CAP_STATE_APPY_MORE.getIndex()){
			res.put("message", "你的预约已经逾期，该招聘会已经举行");
		}else{
			res.put("message", "参加招聘会成功！");
		}
		return JsonUtil.toJson(res);
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="updateCancel/{uuid}",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")	
	public  @ResponseBody String updateCancel(@PathVariable String uuid,String advic , Model model){	
		Map<String,Object> res = new HashMap<>();
		CareerFairAppointment cap =capService.loadByid(uuid);
		cap.setCapAdvice(advic);
		capService.updateCancel(cap);
	    res.put("message", "取消预约成功！");
		return JsonUtil.toJson(res);
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="cacaps",method=RequestMethod.GET)	
	public String listCaCap(CapCafPro cacap, Model model){	
		model.addAttribute("cacap", cacap);
		model.addAttribute("cacaps", capService.findCapCapro(cacap));
		return "cap/cafcaplist";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="cacapExport")	
	public String cacapExport(CapCafPro cacap,HttpServletRequest request, HttpServletResponse response){	
		List<CapCafPro> cacaps = capService.listCapCapro(cacap);
		Workbook wf= ExcelUtiuls.generateExcel(getMapByCacap(cacaps), "招聘会预约信息");
	 return CommonWebUtil.wrieExcel(request, response, wf,"招聘会预约信息.xls");
	}
	private List<Map<String,String>> getMapByCacap(List<CapCafPro> cfs){
		List<Map<String,String>> lms = new ArrayList<Map<String,String>>(); 
		for(CapCafPro cf:cfs){
			Map <String,String> stm = new HashMap<String,String>();
			stm.put("未参加人数", cf.getCnt1()==null?"0":cf.getCnt1().toString());
			stm.put("已参加人数", cf.getCnt2()==null?"0":cf.getCnt2().toString());
			stm.put("逾期人数", cf.getCnt3()==null?"0":cf.getCnt3().toString());
			stm.put("取消预约人数", cf.getCnt4()==null?"0":cf.getCnt4().toString());
			stm.put("预约总人数", cf.getCnt5()==null?"0":cf.getCnt5().toString());
			stm.put("招聘会名", cf.getCareerFairName());
			stm.put("招聘类型", cf.getCareerFairTypeName());
			lms.add(stm);
		}
		return lms;
	 } 
}
