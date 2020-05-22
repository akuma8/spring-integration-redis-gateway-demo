package com.example.flows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.redis.inbound.RedisQueueInboundGateway;

import com.example.service.SelfService;

/**
 * @author Attoumane AHAMADI
 */
@Configuration
public class FlowsFromOtherServices {

	@Bean
	public IntegrationFlow getInfosProfileFlow(RedisQueueInboundGateway inboundGateway, SelfService selfService) {
		return IntegrationFlows.from(inboundGateway)
				.handle(selfService, "handleGetInfosProfile") //Do not use method reference here, the framework will use handle(MessageHandler messageHandler) which is a void method implementation
				.get();
	}
}
