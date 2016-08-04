package com.rta.ws.addcar.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.rta.ws.addcar.dto.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableBinding(CarMetadata.class)
public class CarSinkSocket {

    private static final Logger log = LoggerFactory.getLogger(CarSinkSocket.class);

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Autowired
    ObjectMapper mapper;


    @StreamListener("newcar")
    public void sink(Car car) {
        sendToClients(car);
    }

    public void sendToClients(Car car) {
        String json = "";
        try {
            json = this.mapper.writeValueAsString(car);
        } catch (Exception ex) {ex.printStackTrace();}
        messagingTemplate.convertAndSend("/topic/newcar", json);
    }
}
