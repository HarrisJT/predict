package com.predict.data.entity.builder;

import br.com.devfast.jsurveymonkey.enums.StatusSurveyResponse;
import br.com.devfast.jsurveymonkey.util.GsonFactory;
import com.predict.data.entity.response.CreateQuestionResponse;
import br.com.devfast.jsurveymonkey.commons.Builder;

public class CreateQuestionResponseBuilder extends Builder<CreateQuestionResponse> {

    private CreateQuestionResponse response;

    public CreateQuestionResponseBuilder(String result) {
        try {
            if(result != null){
                this.response = GsonFactory.create().fromJson(result, CreateQuestionResponse.class);
                this.response.processStatusRequest();
            } else {
                this.response = new CreateQuestionResponse(StatusSurveyResponse.ERROR, "empty response");
            }
        } catch (Exception e) {
            this.response = new CreateQuestionResponse(StatusSurveyResponse.ERROR, e.getMessage());
        }
    }

    @Override
    public CreateQuestionResponse getResponse() {
        return response;
    }

}