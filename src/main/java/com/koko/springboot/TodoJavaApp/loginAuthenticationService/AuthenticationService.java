package com.koko.springboot.TodoJavaApp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String userName, String password) {
		boolean isValidUserName = userName.equalsIgnoreCase("Cokesman");
		boolean isValidPassword = password.equalsIgnoreCase("dummypass");
		
		return isValidUserName && isValidPassword;
	}

}
