package com.predict.data.entity;

import java.util.Map;

public class User {

  private String email;
  private Map<String, Double> weights;

  public User() {
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
}
