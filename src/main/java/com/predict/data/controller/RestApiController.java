package com.predict.data.controller;

import com.predict.data.entity.Question;
import com.predict.data.entity.request.CreateQuestionRequest;
import com.predict.data.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

  private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);

  private SurveyService surveyService;

  @Autowired
  public RestApiController(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  //@CrossOrigin(origins = "http://localhost:8080")
  @PostMapping(value = "/question")
  public ResponseEntity postQuestionController(@RequestBody Question question) {
    String surveyId;
    try {
      surveyId = surveyService.createSurvey();
    } catch (Exception e) {
      logger.error("Error creating survey");
      return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }

    question.setSurveyId(surveyId);

    CreateQuestionRequest questionRequest = new CreateQuestionRequest(question);

    surveyService.addQuestion(questionRequest);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}