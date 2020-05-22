package com.example.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.events.OnInfosProfileEvent;

/**
 * @author Attoumane AHAMADI
 */
@Service
public class SelfService {
	public OnInfosProfileEvent handleGetInfosProfile(Message<?> message) {
		String username = (String) message.getPayload();
		Assert.hasText(username, "Username is required");
		return new OnInfosProfileEvent()
				.setUsername(username)
				.setInfosACompleted(true)
				.setInfosBCompleted(true)
				.setCompletionPercentage(60);
	}

}
