package com.predict.data.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;

public class DatabaseController {

  private Firestore db;
  private String PROJECT_ID = "predict-454c2";

  /**
   * Initialize Firestore using the project ID.
   */
  public DatabaseController() throws Exception {
    try {
      //ClassLoader classLoader = getClass().getClassLoader();
      //File file = new File(classLoader.getResource("fb_creds.json").getFile());
      //InputStream serviceAccount = new FileInputStream(file);
      //GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/fb_creds.json").getInputStream()))
          .build();

      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    this.db = FirestoreClient.getFirestore();
  }

  public Firestore getDb() {
    return db;
  }
}
