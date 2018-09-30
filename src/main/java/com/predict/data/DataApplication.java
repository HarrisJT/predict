package com.predict.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataApplication {

    private static final Logger logger = LoggerFactory.getLogger(DataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
        logger.debug("TEST");
    }

}
