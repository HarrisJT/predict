package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;
import org.json.JSONStringer;

import java.util.Date;

public class CreatePageRequest extends Request {

  private String surveyId;

  public CreatePageRequest(String surveyId) {
    setDate(new Date());
    this.surveyId = surveyId;
  }

  public String getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(String surveyId) {
    this.surveyId = surveyId;
  }

    @Override
    public String getJsonBody() {
        JSONStringer json = new JSONStringer();
        json.object()
                .key("title").value("Page 1")
                .key("id").value("1")
                .endObject();

        System.out.println(json.toString());
        return json.toString();
    }
}
