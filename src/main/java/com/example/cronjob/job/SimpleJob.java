package com.example.cronjob.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleJob implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleJob.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Simple job started");
        // Add your job logic here
        LOGGER.info("Simple job finished");
    }
}
