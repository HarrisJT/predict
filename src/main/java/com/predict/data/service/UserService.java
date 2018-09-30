package com.predict.data.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
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

  @Autowired
  private DatabaseController databaseController;

  private DatabaseReference usersRef;

  public UserService() {
    try {
      databaseController = new DatabaseController();
      this.usersRef = databaseController.getUsersRef();
    } catch (Exception ex) {
      logger.error("Failed to initialize database: ", ex);
    }
  }

  public List<User> retrieveAllUsers() {
    Query newQuery = usersRef.orderByKey();
    List<User> users = new ArrayList<>();
    newQuery.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot data : dataSnapshot.getChildren()) {
          User user = data.getValue(User.class);
          users.add(user);
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        logger.error("Failed to retrieveAllUsers: ", databaseError);
      }
    });
    return users;
  }
}
