package com.predict.data.entity;

public class Question {
  private String question;
  private String category;
  private int toSend;
  private int toEnd;

  public int getToSend() {
    return toSend;
  }

  public void setToSend(int toSend) {
    this.toSend = toSend;
  }

  public int getToEnd() {
    return toEnd;
  }

  public void setToEnd(int toEnd) {
    this.toEnd = toEnd;
  }

  public Question(String question, String category) {
    this.question = question;
    this.category = category;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
