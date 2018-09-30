package com.predict.data.entity;

public class Question {

  private String surveyId;
  private String questionId;
  private String title;
  private String category;
  private String toSend;
  private String toEnd;
  private String[] choices;

  public Question() {

  }

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public String getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(String surveyId) {
    this.surveyId = surveyId;
  }

  public String[] getChoices() {
    return choices;
  }

  public void setChoices(String[] choices) {
    this.choices = choices;
  }

  public String getToSend() {
    return toSend;
  }

  public void setToSend(String toSend) {
    this.toSend = toSend;
  }

  public String getToEnd() {
    return toEnd;
  }

  public void setToEnd(String toEnd) {
    this.toEnd = toEnd;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String question) {
    this.title = question;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
