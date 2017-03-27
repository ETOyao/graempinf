package com.wanglei.graempinf.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanglei.basic.util.EnumUtils;
import com.wanglei.graempinf.auth.AuthClass;
import com.wanglei.graempinf.service.IRoleService;
import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.model.Role;

@Controller
@RequestMapping("/admin/role")
@AuthClass
public class RoleContotller {
	private IRoleService roleService;
	private IUserService userService;

	public IRoleService getRoleService() {
		return roleService;
	}
	@Inject
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	@RequestMapping("/roles")
	public String list(Model model) {
		model.addAttribute("roles", roleService.listRole());
		return "role/list";
	}
	
	@RequestMapping("/{roleUuid}")
	public String show(@PathVariable String roleUuid,Model model) {
		model.addAttribute(roleService.load(roleUuid));
		model.addAttribute("us",userService.listRoleUsers(roleUuid));
		return "role/show";
	}
	
	@RequestMapping("/delete/{roleUuid}")
	public String delete(@PathVariable String roleUuid) {
		roleService.delete(roleUuid);
		return "redirect:/admin/role/roles";
	}
	
	@RequestMapping("/clearUsers/{roleUuid}")
	public String clearUsers(@PathVariable String roleUuid) {
		roleService.deleteRoleUsers(roleUuid);
		return "redirect:/admin/role/roles";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Role());
		model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
		return "role/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Role role) {
		roleService.add(role);
		return "redirect:/admin/role/roles";
	}
	
	@RequestMapping(value="/update/{roleUuid}",method=RequestMethod.GET)
	public String update(@PathVariable String roleUuid,Model model) {
		model.addAttribute(roleService.load(roleUuid));
		model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
		return "role/update";
	}
	
	@RequestMapping(value="/update/{roleUuid}",method=RequestMethod.POST)
	public String update(@PathVariable String roleUuid,Role role) {
		Role er = roleService.load(roleUuid);
		er.setRoleName(role.getRoleName());
		er.setRoleType(role.getRoleType());
		er.setRoleDesc(role.getRoleDesc());
		roleService.update(er);
		return "redirect:/admin/role/roles";
	}
}
