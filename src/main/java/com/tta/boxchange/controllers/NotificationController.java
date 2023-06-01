package com.tta.boxchange.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @MessageMapping("/messages")
    public void handleMessage(Notification message) {
        message.setTimestamp(new Date());
        notificationRepository.save(message);
        template.convertAndSend("/socket/chat/" + message.getChannel(), message);
    }
    
    @MessageMapping("/notif")
    public void handleNotif(Notification notification) {
        notification.setTimestamp(new Date());
        notificationRepository.save(notification);
        System.out.println("Notification received on channel /notif: " + notification);
        template.convertAndSend("/socket/notif/" + notification.getChannel(), notification);
    }
    
    @GetMapping("/messages/getNotification/{userId}")
    public List<Notification> getnotificationNonReadByUser(@PathVariable("userId") String userId ){
    	return notificationRepository.findByChannelAndReadDate(userId,null);
    	
    }
    
   /* @PostMapping("/messages/")
    public String updateOfNotification(@RequestBody Notification notif ){
    	return notificationRepository.findByChannelAndReadDate(userId,null);
    	
    }*/

}
