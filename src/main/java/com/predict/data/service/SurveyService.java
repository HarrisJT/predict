package com.predict.data.service;

import br.com.devfast.jsurveymonkey.request.CreateSurveyRequest;
import br.com.devfast.jsurveymonkey.request.GetSurveyRequest;
import br.com.devfast.jsurveymonkey.response.CreateSurveyResponse;
import br.com.devfast.jsurveymonkey.response.GetSurveyResponse;
import br.com.devfast.jsurveymonkey.services.SurveyMonkeyService;
import com.predict.data.util.ConfigManager;
import com.predict.data.entity.Question;
import com.predict.data.util.ParameterStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SurveyService {

    private static final String API_AUTH_TOKEN;
    private static final String SM_API_BASE;


    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    public SurveyService() {
        URL url = null;
        HttpURLConnection con = null;
        try {
            url = new URL(SM_API_BASE);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + API_AUTH_TOKEN + "s");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("param1", "val");
            parameters.put("param1", "val");
            parameters.put("param1", "val");
            parameters.put("param1", "val");

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





//        SurveyMonkeyService surveyMonkeyService = new SurveyMonkeyService(API_AUTH_TOKEN);
        this.surveyMonkeyService = surveyMonkeyService;
    }

    static {
        API_AUTH_TOKEN = ConfigManager.getProperty("api_auth_token");
        SM_API_BASE = ConfigManager.getProperty("sm_api_base");
    }

//    public void newQuestion(Question question) {
//
//    }

    public CreateSurveyResponse createSurvey(Question question) {
        CreateSurveyRequest createSurveyRequest = new CreateSurveyRequest();
        createSurveyRequest.setTitle(question.getCategory());
        createSurveyRequest.setNickname("New question from Predict");

        CreateSurveyResponse createSurveyResponse = surveyMonkeyService.createSurvey(createSurveyRequest);

        System.out.println(createSurveyResponse.getId());
    }

    public void sendSurvey(
//
    public void fetchSurvey() {
        GetSurveyRequest getSurveyRequest = new GetSurveyRequest("ID_SURVEY");
        GetSurveyResponse getSurveyResponse = surveyMonkeyService.getSurvey(getSurveyRequest);
    }






}