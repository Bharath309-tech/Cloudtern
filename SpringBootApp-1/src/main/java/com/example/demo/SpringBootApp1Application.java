package com.example.demo;

import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;

@SpringBootApplication
@RestController
public class SpringBootApp1Application {
	
	@Value("${userNamecloudtern}")
	private String userNamecloudtern;
	
	@Value("${password}")
	private String password;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp1Application.class, args);
	}
	
	@PostMapping("validateLogin")
	public String valiateLogin( @RequestBody User userdetails) {
		//User validation with username and password
		if(userdetails.getUsername().equalsIgnoreCase(userNamecloudtern) &&
				userdetails.getPassword().equals(password)) {
			//Validating mobile number and email id
			if(Pattern.compile("[^9]{0-9}", userdetails.getMobile()) != null) {
				
				return "Welcome Back "+userNamecloudtern;
			}
			else {
				return "Mobile number and Email id is not valid";
			}
			
		}
		else {
			return "Please check..Username and password is not correct";
		}
	}

}
