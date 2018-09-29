package com.predict.data.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.predict.data.controller.DatabaseController;
import com.predict.data.entity.Question;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("QuestionService")
public class QuestionService {

  private Firestore db;

  public QuestionService() {
    DatabaseController controller = new DatabaseController();
    this.db = controller.getDb();
  }

  // TODO: THIS IS BOILERPLATE
  public List<Question> queryForEndedQuestions() throws Exception {
    Date currentTime = new Date();
    ApiFuture<QuerySnapshot> query = db.collection("questions").whereGreaterThan("TO_END", currentTime).get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    List<Question> allQuestions = new ArrayList<>();
    for (QueryDocumentSnapshot document : documents) {
      Question question = document.toObject(Question.class);
      allQuestions.add(question);
    }
    return allQuestions;
  }

  public List<Question> retrieveAllQuestions() throws Exception {
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("questions").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    List<Question> allQuestions = new ArrayList<>();
    for (QueryDocumentSnapshot document : documents) {
      Question question = document.toObject(Question.class);
      allQuestions.add(question);
    }
    return allQuestions;
  }


}
