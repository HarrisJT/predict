package com.predict.data.service;

import br.com.devfast.jsurveymonkey.app.SurveyConfig;
import br.com.devfast.jsurveymonkey.enums.StatusSurveyResponse;
import br.com.devfast.jsurveymonkey.request.CreateSurveyRequest;
import br.com.devfast.jsurveymonkey.response.CreateSurveyResponse;
import br.com.devfast.jsurveymonkey.services.SurveyMonkeyService;
import com.predict.data.entity.builder.CreateQuestionResponseBuilder;
import com.predict.data.entity.request.CreateQuestionRequest;
import com.predict.data.entity.response.CreateQuestionResponse;
import com.predict.data.util.ConfigManager;
import com.predict.data.entity.Question;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
public class SurveyService extends SurveyMonkeyService {

    private static final String API_AUTH_TOKEN;

    private SurveyMonkeyService surveyService;

    @Autowired
    public SurveyService() {
        SurveyMonkeyService surveyService = new SurveyMonkeyService(API_AUTH_TOKEN);
        this.surveyService = surveyService;
    }

    static {
        API_AUTH_TOKEN = ConfigManager.getProperty("api_auth_token");
    }

    public CreateQuestionResponse createQuestion(CreateQuestionRequest request) {
        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(new URI(SurveyConfig.ENDPOINT_V3 + SURVEY_SERVICE + ));

            setRequestAuthentication(httpPost, request.getAuthenticationToken());
            setRequestBody(httpPost, request.getJsonBody());

            CloseableHttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());

            setResponse(result);
            return new CreateQuestionResponseBuilder(result).getResponse();

        } catch (Exception e) {
            return new CreateQuestionResponse(StatusSurveyResponse.ERROR, e.getMessage());
        }
    }


    public void createSurvey(Question question) {
        CreateSurveyRequest createSurveyRequest = new CreateSurveyRequest();
        createSurveyRequest.setTitle(question.getCategory());
        createSurveyRequest.setNickname("New question from Predict");

        CreateSurveyResponse createSurveyResponse = surveyService.createSurvey(createSurveyRequest);

        System.out.println(createSurveyResponse.getId());
    }


//
//    public void fetchSurvey() {
//        GetSurveyRequest getSurveyRequest = new GetSurveyRequest("ID_SURVEY");
//        GetSurveyResponse getSurveyResponse = surveyMonkeyService.getSurvey(getSurveyRequest);
//    }






}