package com.ppl.toyboard.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
        return "login/loginPage.html";
	
	}
}
