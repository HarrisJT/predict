package com.predict.data.service;

import br.com.devfast.jsurveymonkey.request.CreateSurveyRequest;
import br.com.devfast.jsurveymonkey.request.GetSurveyRequest;
import br.com.devfast.jsurveymonkey.response.CreateSurveyResponse;
import br.com.devfast.jsurveymonkey.response.GetSurveyResponse;
import br.com.devfast.jsurveymonkey.services.SurveyMonkeyService;
import com.predict.data.util.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;

public class SurveyService {

    private static final String API_AUTH_TOKEN;


    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    public SurveyService() {
        SurveyMonkeyService surveyMonkeyService = new SurveyMonkeyService(API_AUTH_TOKEN);
        this.surveyMonkeyService = surveyMonkeyService;
    }

    static {
        API_AUTH_TOKEN = ConfigManager.getProperty("api_auth_token");
    }

//    public void newQuestion(Question question) {
//        //TODO: Prep question for survey
//    }

//    public void postSurvey() {
//        CreateSurveyRequest createSurveyRequest = new CreateSurveyRequest();
//        createSurveyRequest.setTitle(question.getCatagory());
//        createSurveyRequest.setNickname("New question from Predict");
//
//        CreateSurveyResponse createSurveyResponse = surveyMonkeyService.createSurvey(createSurveyRequest);
//    }
//
//    public void fetchSurvey() {
//        GetSurveyRequest getSurveyRequest = new GetSurveyRequest("ID_SURVEY");
//        GetSurveyResponse getSurveyResponse = surveyMonkeyService.getSurvey(getSurveyRequest);
//    }






}