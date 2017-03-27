package com.wanglei.graempinf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.basic.util.EnumUtils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.auth.AuthMethod;
import com.wanglei.graempinf.service.IOrgService;
import com.wanglei.graempinf_core.graempinf_core.Enum.ChannelType;
import com.wanglei.graempinf_core.graempinf_core.Enum.OrgEnum;
import com.wanglei.graempinf_core.graempinf_core.dao.Tree;
import com.wanglei.graempinf_core.graempinf_core.model.Channel;
import com.wanglei.graempinf_core.graempinf_core.model.Org;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;

@RequestMapping("/admin/org")
@Controller
@AuthClass
public class OrgController {
	private IOrgService orgService;
	
	public IOrgService getOrgService() {
		return orgService;
	}
	@Inject
	public void setOrgService(IOrgService orgService) {
		this.orgService = orgService;
	}
	@RequestMapping("/orgs")
	public String list(){
		
		return "org/list";
	}
	@RequestMapping("/listdemo")
	public String lisDemo(){
		return "org/list_demo";
	}
	@RequestMapping("/orgsTreeAll")
	public @ResponseBody List<Tree> tree() {
		return orgService.tree();
	}
	@RequestMapping("/orgs/{id}")
	public String listChilds(@PathVariable Integer id,@Param Integer refresh,Model model) {
		if(refresh==null) {
			model.addAttribute("refresh",0);
		} else {
			model.addAttribute("refresh",1);
		}
		Org org =null;
		if(id<=0) {
			org = new Org();
			org.setName(Channel.ROOT_NAME);
			org.setId(Channel.ROOT_ID);
			id=null;
		} else
	       org = orgService.load(id);
		model.addAttribute("pid",org.getId());
		model.addAttribute("parent",org);
		model.addAttribute("childs",orgService.findByParent(id,null));
		return "org/list_child";
	}
	private void initAdd(Model model,Integer pid) {
		if(pid==null) pid = 0;
		Org pc = null;
		if(pid==0) {
			pc = new Org();
			pc.setId(Org.ROOT_ID);
			pc.setName(Org.ROOT_NAME);
		} else {
			pc = orgService.load(pid);
		}
		model.addAttribute("parent", pc);
		model.addAttribute("pid", pid);
		model.addAttribute("types", convertToMap());
	}
	private Map<Integer,String> convertToMap(){
		Map <Integer,String> remap = new HashMap<Integer, String>();
		remap.put(OrgEnum.ORG_CLASS.getIndex(), OrgEnum.ORG_CLASS.getName());
		remap.put(OrgEnum.ORG_XUEYUAN.getIndex(), OrgEnum.ORG_XUEYUAN.getName());
		remap.put(OrgEnum.ORG_DEPARTMENT.getIndex(), OrgEnum.ORG_DEPARTMENT.getName());
		remap.put(OrgEnum.ORG_SCHOOL.getIndex(), OrgEnum.ORG_SCHOOL.getName());
		return remap;
	}
	@RequestMapping(value="/orgs/{id}/add",method=RequestMethod.GET)
	public String add(@PathVariable int id,Model model) {
		model.addAttribute("org", new Org());
		initAdd(model,id);
		return "org/add";
	}
	
	@RequestMapping(value="/orgs/{id}/add",method=RequestMethod.POST)
	public String add(@PathVariable int id,@Valid @ModelAttribute("org")Org org,BindingResult br,Model model) {
		if(br.hasErrors()) {
			initAdd(model,id);
			return "org/add";
		}
		model.addAttribute("types", EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
		orgService.add(org,id);
		return "redirect:/admin/org/orgs/"+id+"?refresh=1";
	}
	@RequestMapping(value="/orgs/{pid}/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int pid,@PathVariable int id) {
		orgService.delete(id);
		return "redirect:/admin/org/orgs/"+pid+"?refresh=1";
	}
	
	@RequestMapping(value="/{pid}/show/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,@PathVariable int pid,Model model) {
		model.addAttribute("org", orgService.load(id));
		initAdd(model, id);
		model.addAttribute("pid", pid);

		return "org/show";
	}
	
	@RequestMapping(value="/orgs/{pid}/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int pid,@PathVariable int id,Model model) {
		model.addAttribute("org", orgService.load(id));
		initAdd(model,id);
		return "org/update";
	}
	
	@RequestMapping(value="/orgs/{pid}/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int pid,@PathVariable int id,@Valid @ModelAttribute("org")Org org,BindingResult br,Model model) {
		if(br.hasErrors()) {
			initAdd(model,id);
			return "org/update";
		}
		Org to = orgService.load(id);
		to.setAddress(org.getAddress());
		to.setAtt1(org.getAtt1());
		to.setAtt2(org.getAtt2());
		to.setAtt3(org.getAtt3());
		to.setName(org.getName());
		to.setOrderNum(org.getOrderNum());
		to.setPhone(org.getPhone());
		to.setTypeId(org.getTypeId());
		to.setOrgCode(org.getOrgCode());
		orgService.update(to);
		return "redirect:/admin/org/orgs/"+pid+"?refresh=1";
	}
	@AuthMethod
	@RequestMapping(value="/orgs/orgList",method=RequestMethod.GET)
	@ResponseBody
	public List<SelectUtils> createOrgList(@Param Integer id,@Param Integer typeId){
		return orgService.listOrgforSelect(id,typeId);
	}
//	@RequestMapping("/persons/{id}")
//	public String showPerson(@PathVariable int id,Integer posId,Model model) {
//		if(posId!=null&&posId>0) {
//			model.addAttribute("posId", posId);
//		} else {
//			posId = null;
//		}
//		model.addAttribute("persons", personService.findPersonAndPosByOrg(id, posId));
//		Org org = orgService.load(id);
//		model.addAttribute("org",org);
//		model.addAttribute("parent", org);
//		return "org/showPerson";
//	}
}
