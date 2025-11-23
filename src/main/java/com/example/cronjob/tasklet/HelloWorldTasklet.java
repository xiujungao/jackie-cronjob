package com.example.cronjob.tasklet;

import com.example.cronjob.service.HelloWorldService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldTasklet implements Tasklet {

    private final HelloWorldService helloWorldService;

    public HelloWorldTasklet(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        helloWorldService.sayHello();
        return RepeatStatus.FINISHED;
    }
}
