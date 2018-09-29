package com.predict.data.controller;

import com.predict.data.entity.Question;
import com.predict.data.service.SurveyService;
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

  private SurveyService surveyService;

  @Autowired
  public RestApiController(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  //@CrossOrigin(origins = "http://localhost:8080")
  @PostMapping(value = "/question")
  public ResponseEntity postQuestionController(@RequestBody Question question) {
    surveyService.newQuestion(question);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}