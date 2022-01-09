package com.etoal.sandbox.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
    private static final String template = "(%s ~ %s ~ %s) %s, %s!";

    private final AtomicLong counter = new AtomicLong(1);

    private final String greetingMessage;
    private final String encodedUsername;

    public GreetingController(@Value("${greeting.message}") final String greetingMessage, @Value("${username}") final String encodedUsername) {
        this.greetingMessage = greetingMessage;
        this.encodedUsername = encodedUsername;
        logUsername();
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws UnknownHostException {
        logUsername();
        InetAddress ip = InetAddress.getLocalHost();
        String response = String.format(template, counter.getAndIncrement(), ip, ip.getHostName(), greetingMessage, name);

        logger.info("Returning response {}", response);

        return response;
    }

    private void logUsername() {
        logger.info("Username {}", encodedUsername == null ? "[not set]" : new String(Base64.getDecoder().decode(encodedUsername)));
    }
}
