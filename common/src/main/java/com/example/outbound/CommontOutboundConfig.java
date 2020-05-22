package com.example.outbound;

import static com.example.channels.CommonChannels.GET_INFOS_PROFILE_CHANNEL;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.redis.outbound.RedisQueueOutboundGateway;

/**
 * @author Attoumane AHAMADI
 */
@Configuration
public class CommontOutboundConfig {

	@Bean
	@ConditionalOnExpression("'${spring.application.name}' ne 'serviceb'")
	public IntegrationFlow infosProfileQueueOutboundGateway(RedisConnectionFactory redisConnectionFactory,
			RedisSerializer<?> redisSerializer) {
		var queueGateway = new RedisQueueOutboundGateway(GET_INFOS_PROFILE_CHANNEL, redisConnectionFactory);
		queueGateway.setExtractPayload(false);
		queueGateway.setSerializer(redisSerializer);
		queueGateway.setRequiresReply(true);
		return IntegrationFlows.from(GET_INFOS_PROFILE_CHANNEL)
				.handle(queueGateway)
				.get();
	}

}
