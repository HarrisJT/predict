package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;
import com.predict.data.entity.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class CreateQuestionRequest extends Request {
    private String heading;
    private String surveyId;
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
        this.surveyId = question.getSurveyId();
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
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

