package com.predict.data.util;

import com.predict.data.entity.Question;
import com.predict.data.entity.request.CreateQuestionRequest;
import com.predict.data.service.QuestionService;
import com.predict.data.service.SurveyService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuestionManager {

  private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);

  private QuestionService questionService;

  private SurveyService surveyService;

  @Autowired
  public QuestionManager(QuestionService questionService, SurveyService surveyService) {
    this.questionService = questionService;
    this.surveyService = surveyService;
  }

  public newQuestion(Question question) {
    CreateQuestionRequest createQuestionRequest = new CreateQuestionRequest(question);


  }

  @Scheduled(cron = "0 0 */1 * * ?")
  public void checkEndedQuestions() {
    logger.debug("Checking for surveys ending");
    List<Question> endedQuestions = new ArrayList<>();
    try {
      endedQuestions = questionService.queryForEndedQuestions();
    } catch (Exception ex) {
      logger.error("Error retrieving ended questions");
    }

    if (!endedQuestions.isEmpty()) {
      // There are ended questions, request the response from SurveyService
    }
  }

}
