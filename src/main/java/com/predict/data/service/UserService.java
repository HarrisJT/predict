package com.predict.data.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.predict.data.controller.DatabaseController;
import com.predict.data.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private FirebaseDatabase db;

  @Autowired
  public UserService(DatabaseController databaseController) {
    logger.debug("UserService initializing");
    try {
      this.db = databaseController.getDb();
    } catch (Exception ex) {
      logger.error("Failed to initialize database: ", ex);
    }
  }

  public List<User> retrieveAllUsers() {
    List<User> users = new ArrayList<>();
    db.getReference("users/").addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot data : snapshot.getChildren()) {
          User user = data.getValue(User.class);
          users.add(user);
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        logger.error("Failed to get all users");
      }
    });

    return users;
  }
}
