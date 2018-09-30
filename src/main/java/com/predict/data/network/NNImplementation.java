package com.predict.data.network;

import com.predict.data.entity.*;
import com.predict.data.service.UserService;
import com.predict.data.util.ConfigManager;

import java.util.ArrayList;

public class NNImplementation {

    private static final String CATEGORY;

    ArrayList<User> userList;  // List of all users (input nodes)
    ArrayList<Choice> choiceList;  // List of possible choices (hidden nodes)
    Choice prediction;  // Prediction
    ArrayList<UserChoicePair> userChoicePairs;  // List of user choice pairs
    private Question currentQuestion;

    static {
        CATEGORY = ConfigManager.getProperty("category");
    }

    public NNImplementation() {
        //this.userList = UserService.retrieveAllUsers();
        this.userList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        choiceList.add(new Choice(1));
        choiceList.add(new Choice(2));


        // Set up Users with their choices
        for (Choice choice : choiceList) {
            for (User user : userList) {
                if (user.getCurrentChoice().equals(choice)) {
                    choice.setScore(choice.getScore() + user.getWeights().get(CATEGORY) * 1.0);
                } else {
                    choice.setScore(choice.getScore() + user.getWeights().get(CATEGORY) * 0.0);
                }
            }
        }

        // Determine the prediction
        if (choiceList.get(0).getScore() >= choiceList.get(1).getScore()) {
            this.prediction = choiceList.get(0);
        } else {
            this.prediction = choiceList.get(1);
        }

        // Wait for result


        // Update Weights
    }
}
