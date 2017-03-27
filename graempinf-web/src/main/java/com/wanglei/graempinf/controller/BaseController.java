package com.wanglei.graempinf.controller;

import org.springframework.ui.Model;

import com.wanglei.graempinf_core.graempinf_core.Enum.MesageEnum;

public class BaseController {
	public void showSuccessMessage(Model model){
		model.addAttribute(MesageEnum.MESSAGE_SUCCESS.getMessageName() ,MesageEnum.MESSAGE_SUCCESS.getMessage());
	}
}
