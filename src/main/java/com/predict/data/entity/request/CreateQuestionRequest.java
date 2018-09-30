package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;
import com.predict.data.entity.Question;
import java.util.Date;
import org.json.JSONStringer;

public class CreateQuestionRequest extends Request {
    private Question question;
    private String surveyId;

    public CreateQuestionRequest(Question question) {
        setDate(new Date());
        this.question = question;
        this.surveyId = question.getSurveyId();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public String getJsonBody() {
        JSONStringer json = new JSONStringer();
        json.object()
                .key("headings").array().object()
                    .key("heading").value(this.question.getTitle())
                    .endObject().endArray()
                .key("family").value("single_choice")
                .key("subtype").value("vertical")
                .key("answers").object()
                    .key("choices").array().object()
                            .key("text").value(this.question.getChoices()[0])
                            .key("visible").value(true)
                            .key("position").value(1)
                        .endObject().object()
                            .key("text").value(this.question.getChoices()[1])
                            .key("visible").value(true)
                            .key("position").value(1)
                        .endObject()
                    .endArray()
                .endObject()
        .endObject();

        System.out.println(json.toString());
        return json.toString();
    }
}

