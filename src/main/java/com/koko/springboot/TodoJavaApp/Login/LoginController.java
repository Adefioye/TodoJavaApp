package com.koko.springboot.TodoJavaApp.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.koko.springboot.TodoJavaApp.loginAuthenticationService.AuthenticationService;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	// http://localhost:8080/login
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String welcome(@RequestParam String name,
			@RequestParam String password, ModelMap model) {
		
		if (authenticationService.authenticate(name, password)) {
			
			model.put("name", name);
			
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials! Try again!");
		
		return "login";
	}
}
