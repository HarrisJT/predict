package com.predict.data.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.predict.data.controller.DatabaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.predict.data.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private Firestore db;

  public UserService() {
    DatabaseController controller = new DatabaseController();
    this.db = controller.getDb();
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

  List<User> retrieveAllUsers() throws Exception {
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("users").get();
    QuerySnapshot querySnapshot = query.get();
    List<User> users = new ArrayList<User>();
    for(QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
      users.add(new User(document.getId()));
    }
    return users;
  }
}
