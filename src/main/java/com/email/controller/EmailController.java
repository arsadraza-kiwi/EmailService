package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailservice;
	String sub="OTP from KiwiTech";
	String message=" Hey Arsad How are you";
	String to="mdarsadrezastm@gmail.com";
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to KiwiTech";
	}
	@RequestMapping(value="/sendmail",method=RequestMethod.GET)
		public void sendEmail(){
		
		boolean flag=this.emailservice.sendEmail(sub,message,to);
		if(flag)
			System.out.println("Send Message Successfully  ");
		else
			System.out.println("Message not send");
		
	}
}
