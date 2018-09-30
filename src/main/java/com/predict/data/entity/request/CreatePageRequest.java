package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;

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
}
