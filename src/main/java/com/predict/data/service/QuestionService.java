package com.predict.data.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.predict.data.controller.DatabaseController;
import com.predict.data.entity.Question;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("questionService")
public class QuestionService {

  private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

  @Autowired
  private DatabaseController databaseController;

  private DatabaseReference questionsRef;

  public QuestionService() {
    logger.debug("QuestionService initialized");
    try {
      databaseController = new DatabaseController();
      this.questionsRef = databaseController.getQuestionsRef();
    } catch (Exception ex) {
      logger.error("Failed to initialize database: ", ex);
    }
  }

  public List<Question> queryForEndedQuestions() {
    logger.debug("queryForEndedQuestions()");
    long currentTime = new Date().getTime();
    Query newQuery = questionsRef.orderByKey();
    List<Question> users = new ArrayList<>();

    newQuery.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot data : dataSnapshot.getChildren()) {
          Question question = dataSnapshot.getValue(Question.class);
          if (data.child("END_AT").exists()) {
            long endTime = new Date(question.getToEnd()).getTime();
            if (currentTime > endTime) {
              users.add(question);
            }
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        logger.error("Failed to queryForEndedQuestions: ", databaseError);
      }
    });

    return users;

  }


}
