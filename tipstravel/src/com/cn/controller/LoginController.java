package com.cn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cn.entity.User;
import com.cn.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class LoginController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String email,String password,Model model)
	{
		User u = userService.login(email);
		if(u==null) 
		{
			model.addAttribute("message", "�û�������");
			return "login";
		}
		else if(u.getPassword()!=password)
		{
			model.addAttribute("message", "�������");
		}
		else
		{
			model.addAttribute("loginUser", u);
			model.addAttribute("message", "��½�ɹ�");
		}
		return "redirect:/user/test";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model,HttpSession session)
	{
		model.asMap().remove("loginUser");
		return "redirect:/login";
	}
}
