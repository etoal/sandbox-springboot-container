package com.etoal.sandbox.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetingControllerTest {

    @Test
    public void testGreeting() throws Exception {
        // initialize variable input
        String name = "aName";
        String encodedUsername = "bXlVc2VybmFtZQo=";

        var expectedValue = "Hello, aName!";

        // initialize mocks

        // initialize class to test
        GreetingController testClass = new GreetingController("Hello", encodedUsername);

        // invoke method on class to test
        var returnValue = testClass.greeting(name);

        // assert return value
        assertTrue(returnValue.contains("Hello, aName!"));
    }

}