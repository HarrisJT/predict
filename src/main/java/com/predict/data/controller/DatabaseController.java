package com.predict.data.controller;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class DatabaseController {

  private Firestore db;
  private String PROJECT_ID = "predict-454c2";

  /**
   * Initialize Firestore using the project ID.
   */
  public DatabaseController() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId(PROJECT_ID)
            .build();
    this.db = firestoreOptions.getService();
  }

  public Firestore getDb() {
    return db;
  }

}
