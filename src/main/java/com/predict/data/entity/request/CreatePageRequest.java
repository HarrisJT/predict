package com.predict.data.entity.request;

import br.com.devfast.jsurveymonkey.commons.Request;

import java.util.Date;

public class CreatePageRequest extends Request {

    public CreatePageRequest() {
        setDate(new Date());
    }
}
