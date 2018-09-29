package com.predict.data;

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
        if (surveyService == null) {
            System.out.println("Failure");
        } else {
            System.out.println("Success");
        }
    }

}
