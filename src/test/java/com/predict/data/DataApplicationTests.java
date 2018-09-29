package com.predict.data;

import com.predict.data.entity.Question;
import com.predict.data.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSurvey() {
        SurveyService surveyService = new SurveyService();
        assert surveyService == null : "Survey Creation Failure";
        System.out.println("Survey Creation Success");
    }
}

//    @Test
//    public void surveyAddQuestion() {
//        SurveyService surveyService = new SurveyService();
//
//        String question = "Does this work?";
//        String category = "testing";
//        Question questionObject = new Question(question, category);
//
//        surveyService.createSurvey(questionObject);
//    }

