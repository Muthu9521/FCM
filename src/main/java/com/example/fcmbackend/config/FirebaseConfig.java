package com.example.fcmbackend.config;


import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


@Configuration
public class FirebaseConfig {

	@PostConstruct
	public void initialize() {
	    try {
	        String base64Config = System.getenv("FIREBASE_CONFIG_BASE64");
	        if (base64Config == null || base64Config.isEmpty()) {
	            System.err.println("❌ FIREBASE_CONFIG_BASE64 is not set.");
	            return;
	        }

	        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Config);
	        InputStream serviceAccount = new ByteArrayInputStream(decodedBytes);

	        FirebaseOptions options = FirebaseOptions.builder()
	                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	                .build();

	        if (FirebaseApp.getApps().isEmpty()) {
	            FirebaseApp.initializeApp(options);
	            System.out.println("✅ Firebase has been initialized from environment variable.");
	        }
	    } catch (Exception e) {
	        System.err.println("❌ Failed to initialize Firebase:");
	        e.printStackTrace();
	    }
	}

}
