package com.predict.data.entity;

import java.util.ArrayList;
import java.util.Map;

public class Question {

  private String id;
  private String surveyId;
  private String title;
  private String category;
  private String toSend;
  private String toEnd;
  private ArrayList<Map<String, String>> choices;

  public Question() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(String surveyId) {
    this.surveyId = surveyId;
  }

  public ArrayList<Map<String, String>> getChoices() {
    return choices;
  }

  public void setChoices(ArrayList<Map<String, String>> choices) {
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
