package com.predict.data;

import com.predict.data.util.EmailManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTests {

    private static final String SUBJECT = "Testing";
    private static final String CONTENT = "Automated testing message";

    @Test
    public void testSendEmail() {
        String[] recipients = new String[] { "predictapp.noreply@gmail.com" };
    }

}
