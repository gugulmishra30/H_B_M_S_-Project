package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.appcontants.AppConstants;
import com.notification.consumer.dto.EmailRequest;

@Service
public class EmailRequestListner {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@KafkaListener(topics = AppConstants.TOPIC, groupId="group_email")
	public void kafakSubscriberContent(String emailRequest) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			EmailRequest emailContent = mapper.readValue(emailRequest, EmailRequest.class);
			
			//This printing method is show only backend console part.
			//System.out.println(emailContent.getTo());
			//System.out.println(emailContent.getSubject());
			//System.out.println(emailContent.getBody());
			
			//This method show in email Id.
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setTo(emailContent.getTo());
			sm.setSubject(emailContent.getSubject());
			sm.setText(emailContent.getBody());
			
			javaMailSender.send(sm);
			
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
	}
}