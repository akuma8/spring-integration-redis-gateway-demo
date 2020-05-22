package com.example.channels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.MessageChannels;

/**
 * @author Attoumane AHAMADI
 */
@Configuration
public class CommonChannels {

	public static final String GET_INFOS_PROFILE_CHANNEL = "infosCompleteProfileChannel";

	@Bean
	public DirectChannel infosCompleteProfileChannel() {
		return MessageChannels
				.direct( GET_INFOS_PROFILE_CHANNEL )
				.get();
	}
}
