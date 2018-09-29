package com.predict.data.service;

import br.com.devfast.jsurveymonkey.request.CreateSurveyRequest;
import br.com.devfast.jsurveymonkey.request.GetSurveyRequest;
import br.com.devfast.jsurveymonkey.response.CreateSurveyResponse;
import br.com.devfast.jsurveymonkey.response.GetSurveyResponse;
import br.com.devfast.jsurveymonkey.services.SurveyMonkeyService;
import org.springframework.beans.factory.annotation.Autowired;

public class SurveyService {

    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    SurveyService() {
        SurveyMonkeyService surveyMonkeyService = new SurveyMonkeyService(API_AUTH_TOKEN);
        this.surveyMonkeyService = surveyMonkeyService;

    }

    public void newQuestion(Question question) {
        //TODO: Prep question for survey
    }

    public void postSurvey() {
        CreateSurveyRequest createSurveyRequest = new CreateSurveyRequest();
        createSurveyRequest.setTitle(question.getCatagory());
        createSurveyRequest.setNickname("New question from Predict");

        CreateSurveyResponse createSurveyResponse = surveyMonkeyService.createSurvey(createSurveyRequest);
    }

    public void fetchSurvey() {
        GetSurveyRequest getSurveyRequest = new GetSurveyRequest("ID_SURVEY");
        GetSurveyResponse getSurveyResponse = surveyMonkeyService.getSurvey(getSurveyRequest);
    }






}