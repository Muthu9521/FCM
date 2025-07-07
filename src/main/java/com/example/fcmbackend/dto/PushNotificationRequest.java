package com.example.fcmbackend.dto;

public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic; // e.g., "all" or device token
    private String image; // ✅ Add this
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getImage() { return image; }
	public void setImage(String image) { this.image = image; }

    // Getters & Setters
}
