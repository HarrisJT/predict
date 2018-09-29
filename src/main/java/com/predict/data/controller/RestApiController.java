package com.predict.data.controller;

import com.predict.data.entity.Question;
import com.predict.data.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

  @Autowired
  public RestApiController() {
    //this.userRepository = userRepository;
  }

  //@CrossOrigin(origins = "http://localhost:8080")
  @RequestMapping(value = "/question", method = RequestMethod.POST)
  public ResponseEntity<Question> register(
      @RequestParam(value = "question") String questionText,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "toSend") int toSend,
      @RequestParam(value = "toEnd") int toEnd

  ) {
    Question question = new Question(questionText, category);
    question.setToSend(toSend);
    question.setToEnd(toEnd);
    return new ResponseEntity<>(SurveyService.newQuestion(question), HttpStatus.OK);
  }

}
