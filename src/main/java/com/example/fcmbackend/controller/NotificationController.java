package com.example.fcmbackend.controller;

import com.example.fcmbackend.dto.PushNotificationRequest;
import com.example.fcmbackend.service.FCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
@CrossOrigin("*") // allow frontend access if needed
public class NotificationController {

    @Autowired
    private FCMService fcmService;

    @PostMapping("/topic")
    public String sendToTopic(@RequestBody PushNotificationRequest request) {
        return fcmService.sendToTopic(
            request.getTopic(),
            request.getTitle(),
            request.getMessage(),
            request.getImage()
        );
    }

}
