package com.predict.data.entity;

import java.util.HashMap;
import java.util.Map;

public class User {

  private String email;
  private Map<String, Double> weights;
  Choice currentChoice;

  public User(String email) {
    this.email = email;
    this.weights = new HashMap<>();
    this.weights.put("Inter_Politics", 0.1);
    this.weights.put("Nation_Politics", 0.1);
    this.weights.put("Economics", 0.1);
    this.weights.put("Entertainment", 0.1);
    this.weights.put("Sports", 0.1);
    this.weights.put("Technology", 0.1);
    this.weights.put("Biology", 0.1);
    this.weights.put("Environment", 0.1);
    this.weights.put("Natural_Disasters", 0.1);
    //TODO this.currentChoice = choice from survey
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Map<String, Double> getWeights() {
    return weights;
  }

  public void setWeights(Map<String, Double> weights) {
    this.weights = weights;
  }

  public Choice getCurrentChoice() {
    return currentChoice;
  }

  public void setCurrentChoice(Choice currentChoice) {
    this.currentChoice = currentChoice;
  }
}
