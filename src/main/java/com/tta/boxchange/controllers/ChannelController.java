package com.tta.boxchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.payload.request.ReadReceiptRequest;
import com.tta.boxchange.repositories.NotificationRepository;

@CrossOrigin("*")
@RestController
public class ChannelController {
	
	 @Autowired
	    NotificationRepository notifRepository;

	    @GetMapping(value = "/messages/{channelId}")
	    public Page<Notification> findMessages(Pageable pageable, @PathVariable("channelId") String channelId) {
	        return notifRepository.findAllByChannel(channelId, pageable);
	    }

	    @PostMapping(value = "/messages")
	    public void sendReadReceipt(@RequestBody ReadReceiptRequest request) {
	    	notifRepository.sendReadReceipt(request.getChannel(), request.getUsername());
	    }

}
