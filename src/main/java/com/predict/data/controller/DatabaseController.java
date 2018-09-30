package com.predict.data.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseController {

  private static final Logger logger = LoggerFactory.getLogger(DatabaseController.class);
  //private String PROJECT_ID = "predict-454c2";

  private FirebaseDatabase db;


  /**
   * Initialize Firestore using the project ID.
   */
  public DatabaseController() {
    try {
      if (FirebaseApp.getApps().isEmpty()) {
        logger.debug("DatabaseController initializing");
        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials
                .fromStream(new ClassPathResource("/fb_creds.json").getInputStream()))
            .setDatabaseUrl("https://predict-454c2.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(options);
        logger.debug("Successfully connected to database.");

        this.db = FirebaseDatabase.getInstance();
      }
    } catch (IOException ex) {
      logger.debug("Failed to connect to database: ", ex);
    }
  }


  public FirebaseDatabase getDb() {
    return db;
  }
}
