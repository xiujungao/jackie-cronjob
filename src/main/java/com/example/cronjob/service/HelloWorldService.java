package com.example.cronjob.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelloWorldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldService.class);

    public void sayHello() {
        LOGGER.info("Hello world " + LocalDateTime.now());
    }
}
