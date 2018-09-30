package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;
import com.predict.data.entity.Question;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class CreateQuestionRequest extends Request {
    private Question question;


    public CreateQuestionRequest(Question question) {
        setDate(new Date());
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String getJsonBody() {
        JSONStringer json = new JSONStringer();
        json.object()
                .key("headings").array().object()
                    .key("heading").value(this.question)
                    .endObject().endArray()
                .key("family").value("single_choice")
                .key("subtype").value("vertical")
                .key("answers").object()
                    .key("choices").array().object()
                            .key("text").value("fill")
                            .key("visible").value(true)
                            .key("position").value(1)
                        .endObject().object()
                            .key("text").value("fill")
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

