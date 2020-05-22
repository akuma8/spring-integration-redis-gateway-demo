package com.example.inbound;

import static com.example.channels.CommonChannels.GET_INFOS_PROFILE_CHANNEL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.integration.redis.inbound.RedisQueueInboundGateway;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Attoumane AHAMADI
 */
@Configuration
public class InboundConfiguration {

	@Bean
	public RedisQueueInboundGateway infosProfileQueueInboundGateway(RedisConnectionFactory connectionFactory,
			ThreadPoolTaskExecutor taskExecutor, RedisSerializer<?> redisSerializer) {
		var inboundGateway = new RedisQueueInboundGateway(GET_INFOS_PROFILE_CHANNEL, connectionFactory);
		inboundGateway.setTaskExecutor(taskExecutor);
		inboundGateway.setSerializer(redisSerializer);
		inboundGateway.setExtractPayload(false);
		return inboundGateway;
	}
}
