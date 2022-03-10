package com.email.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String subject,String message,String to) {
		boolean flag=false;
		//String host="smtp.gmail.com";
		String from="arsad.raza.kiwi@gmail.com";
		Properties properties=System.getProperties();
		System.out.println("PROPERTIES"+properties);
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.host","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		 Session session = Session.getInstance(properties,new Authenticator() {
			
		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			String s="arsad.raza.kiwi@gmail.com";
			String p="Raza@1997";
			return new PasswordAuthentication(s,p);
		}
	});
		session.setDebug(true);
		MimeMessage m=new MimeMessage(session);
		try {
		m.setFrom(from);
		m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		m.setSubject(subject);
		m.setText(message);
		Transport.send(m);
		System.out.println("Sent Success.........");
		flag=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
