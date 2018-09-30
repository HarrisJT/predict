package com.predict.data.ServiceTests;

import com.predict.data.controller.DatabaseController;
import com.predict.data.entity.Question;
import com.predict.data.entity.request.CreateQuestionRequest;
import com.predict.data.service.SurveyService;
import com.predict.data.service.UserService;
import com.predict.data.util.ConfigManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

public class SurveyServiceTest {
    DatabaseController databaseController;
    private static final String API_AUTH_TOKEN;

    static {
        API_AUTH_TOKEN = ConfigManager.getProperty("api_auth_token");
    }

    @Before
    public void before() {
        // Create Mocks
        this.databaseController = mock(DatabaseController.class);
    }

    @After
    public void after() {
    }

    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    public void createSurveyTest() {
    }

//    @Test
//    public void addQuestionTest() {
//        Question question = new Question();
//        question.setSurveyId("158930526");
//        question.setTitle("Test Question?");
//        question.setCategory("Testing");
//        ArrayList<Map<String,String>> choices = new ArrayList<>();
//        Map<String,String> map = new HashMap<>();
//        map.put("text", "Success");
//        map.put("text","Failure");
//        question.setChoices(choices);
//
//        CreateQuestionRequest createQuestionRequest = new CreateQuestionRequest(question);
//        createQuestionRequest.setAuthenticationToken(API_AUTH_TOKEN);
//
//
//
//
//    }
//
//    @Test
//    public void fetchSurveyTest() {
//        UserService userService = new UserService(databaseController);
//        SurveyService surveyService = new SurveyService(databaseController, userService);
//
//
//        surveyService.fetchSurvey();
//    }
}
