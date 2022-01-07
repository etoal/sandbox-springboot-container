package com.etoal.sandbox.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

     private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue = "World") String name) {
        String response = String.format("Hello, %s!", name);
        logger.info("Returning response {}", response);

        return response;
    }
}
