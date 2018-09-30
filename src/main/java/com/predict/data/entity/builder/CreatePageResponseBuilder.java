package com.predict.data.entity.builder;

import br.com.devfast.jsurveymonkey.enums.StatusSurveyResponse;
import br.com.devfast.jsurveymonkey.util.GsonFactory;
import com.predict.data.entity.response.CreatePageResponse;
import br.com.devfast.jsurveymonkey.commons.Builder;


public class CreatePageResponseBuilder extends Builder<CreatePageResponse> {

    private CreatePageResponse response;

    public CreatePageResponseBuilder(String result) {
        try {
            if(result != null){
                this.response = GsonFactory.create().fromJson(result, CreatePageResponse.class);
                this.response.processStatusRequest();
            } else {
                this.response = new CreatePageResponse(StatusSurveyResponse.ERROR, "empty response");
            }
        } catch (Exception e) {
            this.response = new CreatePageResponse(StatusSurveyResponse.ERROR, e.getMessage());
        }
    }

    @Override
    public CreatePageResponse getResponse() {
        return response;
    }

}