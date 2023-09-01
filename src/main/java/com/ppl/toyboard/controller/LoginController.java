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
@RequestMapping(value="/user")
public class LoginController {
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@GetMapping(path = "/login")
	public String getLogin(Model model) {
	    return "user/loginPage.html";
	}
	@PostMapping(path="/login")
	public String postLogin(UserVO user) {
		if(loginService.checkUser(user)) {
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@GetMapping(path="/register")
	public String getRegister(Model model) {
	    return "user/registerPage.html";
	}
	@PostMapping(path="/register")
	public String postRegister(UserVO user) {
		if(loginService.insertUser(user)) {
			UserVO checkUser = loginService.getUser(user);
			System.out.println(checkUser.getUs_nickname() + " 유저 가입 완료");
			return "redirect:/";
		}
		return "redirect:/";
	}
	
}
