package com.predict.data.ServiceTests;

import com.predict.data.controller.DatabaseController;
import com.predict.data.controller.RestApiController;
import com.predict.data.service.SurveyService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SurveyServiceTest {
    @Before
    public void before() {
        DatabaseController databaseController = mock(DatabaseController.class);
        RestApiController restApiController = mock(RestApiController.class);
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
        SurveyService surveyService = new SurveyService();
        assert surveyService != null : "Survey Creation Success";
        System.out.println("Survey Creation Failure");
    }
}
