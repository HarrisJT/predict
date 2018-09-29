package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;
import com.predict.data.entity.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class CreateQuestionRequest extends Request {
    private String heading;
    private String family;
    private String subtype;
    private Answers answers;


    public CreateQuestionRequest(Question question) {
        setDate(new Date());
        this.heading = question.getTitle();
        this.family = "single_choice";
        this.subtype = "vertical";
        this.answers = new Answers();
        this.answers.setChoices(question.getChoices());
    }

    class Answers {
        ArrayList<Map<String, String>> choices;

        public Answers() {
            this.choices = new ArrayList<>();
        }

        public ArrayList<Map<String, String>> getChoices() {
            return choices;
        }

        public void setChoices(ArrayList<Map<String, String>> choices) {
            this.choices = choices;
        }
    }
}

