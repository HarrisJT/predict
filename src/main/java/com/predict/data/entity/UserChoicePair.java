package com.predict.data.entity;

import com.predict.data.util.ConfigManager;

public class UserChoicePair {

    private static final String CATEGORY;

    private User user;  // Connection between User and Choice
    private Choice choice;
    private double weight;  // Weight of this connection
    private double bias;  // Bias of the choice

    static {
        CATEGORY = ConfigManager.getProperty("category");
    }

    //Create an object with a given parent node
    //and connect weight
    public UserChoicePair(User user, Choice choice, Double bias) {
        this.weight = bias * user.getWeights().get(CATEGORY);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
