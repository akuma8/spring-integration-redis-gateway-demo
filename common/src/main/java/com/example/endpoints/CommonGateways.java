package com.example.endpoints;

import static com.example.channels.CommonChannels.GET_INFOS_PROFILE_CHANNEL;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.example.events.OnInfosProfileEvent;


/**
 * @author Attoumane AHAMADI
 */
@MessagingGateway
public interface CommonGateways {

	/**Get {@link OnInfosProfileEvent} from serviceb */
	@Gateway(requestChannel = GET_INFOS_PROFILE_CHANNEL)
	OnInfosProfileEvent checkInfosProfile(String username);
}
