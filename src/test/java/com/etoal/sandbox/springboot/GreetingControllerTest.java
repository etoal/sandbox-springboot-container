package com.etoal.sandbox.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingControllerTest {

    @Test
    public void testGreeting() throws Exception {
        // initialize variable input
        String name = "aName";

        var expectedValue = "Hello, aName!";

        // initialize mocks

        // initialize class to test
        GreetingController testClass = new GreetingController();

        // invoke method on class to test
        var returnValue = testClass.greeting(name);

        // assert return value
        assertEquals(expectedValue, returnValue);
    }

}