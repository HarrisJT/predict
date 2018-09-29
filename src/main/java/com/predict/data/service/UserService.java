package com.predict.data.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.predict.data.controller.DatabaseController;
import com.predict.data.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private Firestore db;

  private DatabaseController databaseController;

  @Autowired
  public UserService() {
    try {
      databaseController = new DatabaseController();
      this.db = databaseController.getDb();
    } catch (Exception ex) {
      logger.error("Failed to initialize database: ", ex);
    }
  }

  void writeToUser(String username, Map<String, Object> data) throws Exception {
    DocumentReference docRef = db.collection("users").document(username);
//    Map<String, Object> data = new HashMap<>();
//    data.put("first", "Ada");
//    data.put("last", "Lovelace");
//    data.put("born", 1815);
    // asynchronously write data
    ApiFuture<WriteResult> result = docRef.set(data);
    // result.get() blocks on response
    System.out.println("Update time : " + result.get().getUpdateTime());
  }

  // TODO: THIS IS BOILERPLATE
  void queryUser() throws Exception {
    ApiFuture<QuerySnapshot> query =
        db.collection("users").whereLessThan("age", 100).get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      // Do stuff
      System.out.println(document.getDouble("age"));
    }
  }

  public List<User> retrieveAllUsers() throws Exception {
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("users").get();
    QuerySnapshot querySnapshot = query.get();
    List<User> users = new ArrayList<User>();
    for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
      users.add(new User(document.getId()));
    }
    return users;
  }
}
