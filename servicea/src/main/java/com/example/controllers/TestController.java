package com.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.CommonGateways;
import com.example.events.OnInfosProfileEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Attoumane AHAMADI
 */
@Slf4j
@RestController
@RequestMapping(value = "/infos", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TestController {
	private final CommonGateways commonGateways;

	@GetMapping("/{username}")
	public OnInfosProfileEvent getInfosProfile(@PathVariable("username") String username) {
		var response = commonGateways.checkInfosProfile(username);
		log.debug("Response from serviceb: {}", response);
		return response;
	}

}
