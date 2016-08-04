package com.rta.ws.addcar.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface CarMetadata {
	
		@Input("newcar")
    	SubscribableChannel read();
	 
}