package com.bragalund.camel.appa.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // timer
        // Transform data
        // log
        from("timer:first-timer")
                .transform().constant("My Constant Message")
                .to("log:first-timer");
    }
}
