package com.example.fcmbackend.service;


import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

	public String sendToTopic(String topic, String title, String message, String imageUrl) {
	    Notification notification = Notification.builder()
	            .setTitle(title)
	            .setBody(message)
	            .setImage(imageUrl) // ✅ very important
	            .build();

	    Message fcmMessage = Message.builder()
	            .setNotification(notification)
	            .setTopic(topic)
	            .build();

	    try {
	        return FirebaseMessaging.getInstance().send(fcmMessage);
	    } catch (Exception e) {
	        return "Error: " + e.getMessage();
	    }
	}

}
