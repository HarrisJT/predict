package com.predict.data.entity;

public class Question {
  private String question;
  private String category;

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
