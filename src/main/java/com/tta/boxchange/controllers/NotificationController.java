package com.tta.boxchange.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.repositories.NotificationRepository;

@CrossOrigin("*")
@RestController

public class NotificationController {
	
	@Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private NotificationRepository notificationRepository;
    
    
    @MessageMapping("/notif")
    public void handleNotif(Notification notification) {
        notification.setTimestamp(new Date());
        notificationRepository.save(notification);
        System.out.println("Notification received on channel /notif: " + notification);
        template.convertAndSend("/channel/notif/" + notification.getChannel(), notification);
    }

}
