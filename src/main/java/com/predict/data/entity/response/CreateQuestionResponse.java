package com.predict.data.entity.response;

import br.com.devfast.jsurveymonkey.commons.Response;
import br.com.devfast.jsurveymonkey.enums.StatusSurveyResponse;

public class CreateQuestionResponse extends Response {

    public CreateQuestionResponse (StatusSurveyResponse status, String message) {
        super(status, message);
    }
}
