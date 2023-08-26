package com.ppl.toyboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppl.toyboard.root.service.LoginService;
import com.ppl.toyboard.root.vo.UserVO;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@GetMapping()
	public String getLogin(Model model) {
	    return "login/loginPage.html";
	}
	@PostMapping()
	public String postLogin(UserVO user) {
		if(loginService.checkUserVO(user)) {
			return "redirect:/";
		}
		return "redirect:/";
	}
	
}
