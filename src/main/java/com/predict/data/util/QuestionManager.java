package com.predict.data.util;

import com.predict.data.entity.Question;
import com.predict.data.service.QuestionService;
import com.predict.data.service.SurveyService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("questionManager")
public class QuestionManager {

  private static final Logger logger = LoggerFactory.getLogger(QuestionManager.class);

  private QuestionService questionService;

  private SurveyService surveyService;

  @Autowired
  public QuestionManager(QuestionService questionService, SurveyService surveyService) {
    logger.debug("QuestionManager initializing");
    this.questionService = questionService;
    this.surveyService = surveyService;
    checkEndedQuestions();
  }

  @Scheduled(cron = "0 0 */1 * * ?")
  public void checkEndedQuestions() {
    logger.debug("Checking for surveys ending");
    LinkedList<Question> endedQuestions = questionService.queryForEndedQuestions();

    if (!endedQuestions.isEmpty()) {
      // There are ended questions, request the response from SurveyService
      Question endedQuestion = endedQuestions.getFirst();
      surveyService.fetchSurvey(endedQuestion.getSurveyId());
    }
  }

}
