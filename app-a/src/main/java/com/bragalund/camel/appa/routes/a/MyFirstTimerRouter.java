package com.bragalund.camel.appa.routes.a;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent loggingProcessingComponent;

    @Override
    public void configure() throws Exception {
        // timer
        // Transform data
        // log
        from("timer:first-timer")
                .bean(loggingProcessingComponent)
                .transform().constant("My Constant Message")
                .bean(loggingProcessingComponent)
                .bean(getCurrentTimeBean)
                .bean(loggingProcessingComponent)
                .process(new SimpleLoggingProcessor())
                .to("log:first-timer");
    }
}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime() {
        return "Time is now " + LocalDateTime.now();
    }
}

@Component
class SimpleLoggingProcessingComponent {

    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);

    public void process(String message) {
        logger.info("SimpleLoggingProcessingComponent {}", message);
    }
}

@Component
class SimpleLoggingProcessor implements org.apache.camel.Processor {

    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info("SimpleLoggingProcessingComponent {}", exchange.getMessage().getBody());
    }
}