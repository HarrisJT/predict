package com.predict.data.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.predict.data.controller.DatabaseController;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private Firestore db;

  public QuestionService() {
    DatabaseController controller = new DatabaseController();
    this.db = controller.getDb();
  }

  // TODO: THIS IS BOILERPLATE
  void queryQuestions() throws Exception {
    ApiFuture<QuerySnapshot> query =
        db.collection("questions").whereLessThan("age", 100).get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      // Do stuff
      System.out.println(document.getDouble("age"));
    }
  }

  void retrieveAllQuestions() throws Exception {
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("questions").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println("Question: " + document.getId());
    }
  }
}
