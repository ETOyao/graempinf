package com.wanglei.graempinf.controller;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wanglei.basic.util.ExcelUtiuls;
import com.wanglei.basic.util.StringUtils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.IOrgService;
import com.wanglei.graempinf.service.IStudentService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.web.CommonWebUtil;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.model.GraEmpInfException;
import com.wanglei.graempinf_core.graempinf_core.model.Org;
import com.wanglei.graempinf_core.graempinf_core.model.Student;
@Controller
@RequestMapping("/admin/student")
@AuthClass
public class StudentController extends BaseController{
	Logger log = Logger.getLogger(StudentController.class);
	private IStudentService studentService;
	private IUserService userService;
	private IOrgService orgService;
	
	public IOrgService getOrgService() {
		return orgService;
	}
	@Inject
	public void setOrgService(IOrgService orgService) {
		this.orgService = orgService;
	}
	public IStudentService getStudentService() {
		return studentService;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String list(Student stu,Model model){
		model.addAttribute("stu", stu);
		model.addAttribute("students", studentService.findByPager(stu));
	return "student/list";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/import",method=RequestMethod.GET)
	public String importStuinfo(Model model){
	return "student/importInfo";
	}

	private void inintAdd(Model model){
		model.addAttribute("student",new Student());
		model.addAttribute("types", convertToMap("types"));
		model.addAttribute("isTran", convertToMap("isTran"));
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		inintAdd(model);
		return "student/add";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid Student stu , BindingResult br, Integer colid ,Integer depid , Integer teaid ,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			return"student/add";
		} 	
		Org col = orgService.getOrgNameById(colid);
		Org dep = orgService.getOrgNameById(depid);
		Org tea = orgService.getOrgNameById(teaid);
		if(null != col && null != dep && null != tea ){
		stu.setCollegeid(colid);
		stu.setDeptid(depid);
		stu.setStuTeamid(teaid);
		stu.setCollegeName(col.getName());
		stu.setCollegeNum(col.getOrgCode());
		stu.setDeptName(dep.getName());
		stu.setDeptNnum(dep.getName());
		stu.setStuTeam(tea.getName());
		stu.setStuTeamNum(tea.getOrgCode());	
		}
		
		studentService.add(stu);
		this.showSuccessMessage(model);
		return "redirect:/admin/student/students ";
	}
	private Map<Integer,String> convertToMap(String type){
		Map <Integer,String> remap = new HashMap<Integer, String>();
		if("types".equals(type)){
			remap.put(BaseCodeEnum.POVERTYLEVEl_NO.getIndex(),BaseCodeEnum.POVERTYLEVEl_NO.getName());
			remap.put(BaseCodeEnum.POVERTYLEVEl_DEFAULT.getIndex(),BaseCodeEnum.POVERTYLEVEl_DEFAULT.getName());
			remap.put(BaseCodeEnum.POVERTYLEVEl_ORDINARY.getIndex(),BaseCodeEnum.POVERTYLEVEl_ORDINARY.getName());
			remap.put(BaseCodeEnum.POVERTYLEVEl_SPECAIL.getIndex(),BaseCodeEnum.POVERTYLEVEl_SPECAIL.getName());
		}if("isTran".equals(type)){
	      remap.put(BaseCodeEnum.IS_TRAN_DEFAULT.getIndex(),BaseCodeEnum.IS_TRAN_DEFAULT.getName());
		remap.put(BaseCodeEnum.IS_TRAN_YES.getIndex(),BaseCodeEnum.IS_TRAN_YES.getName());
		remap.put(BaseCodeEnum.IS_TRAN_NO.getIndex(),BaseCodeEnum.IS_TRAN_NO.getName());
		}
		return remap;
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam(value="ids") String [] ids){
		studentService.delete(ids);
		return "删除成功！";
	}
	
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="/update/{stuUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String stuUuid,Model model){
		inintAdd(model);
		model.addAttribute("student", studentService.listById(stuUuid));
		return "student/update";
	}
	/**
	 * <p>Description:完善学生信息的方法<p>
	 * @param model
	 * @return
	 * @author wanglei 2017年3月19日
	 */
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="/updateSelf",method=RequestMethod.GET)
	public String updateSelf(Model model){
		inintAdd(model);
		//学生信息完善的入口 如果信息为提交则不能编辑
			String stuUuid=userService.getCurentLoginUser().getStuUuid();
			Student stu = studentService.listById(stuUuid);
			model.addAttribute("student", stu);
			if(stu.getFinshStatus()==9){
				return "student/show";
			}
			return "student/updateSelf";
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping(value="/update/{stuUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String stuUuid,@Valid Student stu , BindingResult br, Integer colid ,Integer depid , Integer teaid ,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			model.addAttribute("student", stu);
			return "student/update";
		}
		Student temp = studentService.listById(stuUuid);
		if(null !=temp){
		Org col = orgService.getOrgNameById(colid);
		Org dep = orgService.getOrgNameById(depid);
		Org tea = orgService.getOrgNameById(teaid);
		if(null != col && null != dep && null != tea ){
			stu.setCollegeid(colid);
			stu.setDeptid(depid);
			stu.setStuTeamid(teaid);
			stu.setCollegeName(col.getName());
			stu.setCollegeNum(col.getOrgCode());
			stu.setDeptName(dep.getName());
			stu.setDeptNnum(dep.getName());
			stu.setStuTeam(tea.getName());
		      stu.setStuTeamNum(tea.getOrgCode());	
		}
			studentService.update(stu);
		}else{
			log.error("学生id为空！更新出错！");
			throw new GraEmpInfException("更新的学生不存在！不能更新");	
		}
	return "redirect:/admin/student/students "; 
	}
	@AuthMethod(role="ROLE_STUDENT")
	@RequestMapping(value="/updateSelf/{stuUuid}",method=RequestMethod.POST)
	public String updateSelf(@PathVariable String stuUuid,@Valid Student stu , BindingResult br, Integer colid ,Integer depid , Integer teaid ,Model model){
		if(br.hasErrors()){
			inintAdd(model);
			model.addAttribute("student", stu);
			return "student/updateSelf";
		}
		Student temp = studentService.listById(stuUuid);
		//如果状态为提交则进入查看页面不允许编辑
		if(null !=temp){
		Org col = orgService.getOrgNameById(colid);
		Org dep = orgService.getOrgNameById(depid);
		Org tea = orgService.getOrgNameById(teaid);
		if(null != col && null != dep && null != tea ){
			stu.setCollegeid(colid);
			stu.setDeptid(depid);
			stu.setStuTeamid(teaid);
			stu.setCollegeName(col.getName());
			stu.setCollegeNum(col.getOrgCode());
			stu.setDeptName(dep.getName());
			stu.setDeptNnum(dep.getName());
			stu.setStuTeam(tea.getName());
		    stu.setStuTeamNum(tea.getOrgCode());	
		  }
			//此处只更新学生信息
		  studentService.updateStudent(stu);
		}else{
			log.error("学生id为空！更新出错！");
			throw new GraEmpInfException("更新的学生不存在！不能更新");	
		}
		if(stu.getFinshStatus()==9){
			inintAdd(model);
			model.addAttribute("student", temp);
			return "student/show";
		}
		return "student/updateSelf";
	}
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="/{stuUuid}",method=RequestMethod.GET)
	public String load(@PathVariable String stuUuid,Model model){
		model.addAttribute("student", studentService.listById(stuUuid));
		return "student/show";
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
	@AuthMethod(role="ROLE_STUDENT,ROLE_TEACHTER")
	@RequestMapping(value="imgUp",produces = "application/text; charset=utf-8")
	@ResponseBody
	 public String upload(HttpServletRequest request, String stuUuid ,@RequestParam("stuimg") MultipartFile file ) {
        log.info("---------开始上传图片--------------");
        String msg = "上传图片成功！";
        Student stu = studentService.listById(stuUuid);
        if(null != stu){
      	  String path = request.getSession().getServletContext().getRealPath("/resources/stuphoto");
              String _fileName = file.getOriginalFilename();
              String fielName =stuUuid+"."+_fileName.substring(_fileName.lastIndexOf(".")+1);
              File targetFile = new File(path, fielName);
              if (!targetFile.exists()) {
                  targetFile.mkdirs();
              }
              // 保存
              try {
                  file.transferTo(targetFile);
                  log.info("---------开始写图片路径入数据库--------------");
                  stu.setImgurl("\\resources\\stuphoto\\"+fielName);
                  studentService.update(stu);
              } catch (Exception e) {
            	  msg="上传图片失败！";
                  e.printStackTrace();
              }
        }
        return msg;
    }
	@AuthMethod(role="ROLE_TEACHTER")
	@RequestMapping("/downloadstu_template")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		String fileName = "stu_template.xls";
		return CommonWebUtil.download(request, response, fileName);
	}
	@AuthMethod(role="ROLE_TEACHTER")
	@ResponseBody
	@RequestMapping(value="importstus",produces = "application/text; charset=utf-8")
	public String importStuInfo(HttpServletRequest request ,@RequestParam("stuInfos") MultipartFile file ){
		String msg = "导入信息成功";
		if(null == file){
			msg = "未选择模板不能上传！";
		}else{
			try {
				InputStream targetFile = file.getInputStream();
				List<Map<String,String>> datas = ExcelUtiuls.parseExcel(targetFile);
				if(null!=datas && datas.size()>0){
					List <Student> stus = getStudnetByMap(datas);
						studentService.addStudents(stus);
				}else{
					msg ="导入的学生信息为空！";
				}
			} catch (Exception e) {
				log.error("------------------获取文件二进制内容出错！或者模板出错！"+e.getMessage());
				msg =e.getMessage();
				return msg;
			}
		}
		return msg;
	}
	/**
	 * <p>Description:根据模板的学生信息转换成实体类<p>
	 * @param lmap
	 * @return
	 * @author WangLei 2017年2月24日
	 */
	private List<Student> getStudnetByMap (List<Map<String,String>>  lmap){
		List<Student> stus = new ArrayList<Student>();
		List<String> stuNums = studentService.listStuNums();
		List<String> values = new ArrayList<String>();
		Student stu = null;
		int index = 0;
		for(Map<String,String> ms: lmap){
			stu = new Student();
			Set<String> keys = ms.keySet();
			for(String key: keys){
				String value = ms.get(key);
				if(null!=value && StringUtils.isNotEmpty(value)){
					switch (key) {
						case "考生号" :
							stu.setExamineeNum(value);
							break;
					       case "学号" :
					      	 if(stuNums.contains(value)|| values.contains(value) ){
					      		 throw new GraEmpInfException("导入失败！第"+(index+1)+"行的学生已经存在！");	 
					      	 }else{
					      		 values.add(value);
					      		 stu.setStuNum(value); 
					      	 }
							break;
					       case "姓名" :
							stu.setSutName(value);
								break;
					       case "身份证号" :
							stu.setIdCardNum(value);
								break;
					}	
				}
			}
			index ++;
			stus.add(stu);
			
		}
		return stus;
	}
	@AuthMethod(role="ROLE_TEACHTER")
	 @RequestMapping("/exportstuinfo")
	public String exPort(Student stu,HttpServletRequest request, HttpServletResponse response){
		 List<Student> stus = studentService.listStudent(stu);
		 Workbook wf= ExcelUtiuls.generateExcel(getMapByStudnet(stus), "学生信息");
		 return CommonWebUtil.wrieExcel(request, response, wf,"学生信息.xls");
	 }
	 private List<Map<String,String>> getMapByStudnet(List<Student> stus){
		List<Map<String,String>> lms = new ArrayList<Map<String,String>>(); 
		for(Student stu:stus){
			Map <String,String> stm = new HashMap<String,String>();
			stm.put("性别", stu.getGender()==null?" ":stu.getGender()==1?"男":"女");
			stm.put("准考证号", stu.getExamineeNum());
			stm.put("姓名", stu.getSutName());
			stm.put("身份证号", stu.getIdCardNum());
			stm.put("学号", stu.getStuNum());
			stm.put("学院", stu.getCollegeName());
			stm.put("院系", stu.getDeptName());
			stm.put("班级", stu.getStuTeam());
			stm.put("信息状态", stu.getFinshStatus()==0?"未完善":"已完善");
			lms.add(stm);
		}
		return lms;
	 } 
	
}
