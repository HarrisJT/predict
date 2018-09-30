package com.predict.data.entity.response;

import br.com.devfast.jsurveymonkey.commons.Response;
import br.com.devfast.jsurveymonkey.enums.StatusSurveyResponse;

public class CreatePageResponse extends Response {

    private String href;
    private String id;

    public CreatePageResponse(StatusSurveyResponse status, String message) {
        super(status, message);
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
