package com.wugq.taotao.test.controller;


import com.wugq.taotao.test.pojo.SysUser;
import com.wugq.taotao.test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/showUserToJspById/{userId}")
	public String showUser(Model model, @PathVariable("userId") Long userId){
		SysUser user = this.sysUserService.getById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/showUserToJSONById/{userId}")
	@ResponseBody
	public SysUser showUser(@PathVariable("userId") Long userId){
		SysUser user = sysUserService.getById(userId);
		return user;
	}

}
