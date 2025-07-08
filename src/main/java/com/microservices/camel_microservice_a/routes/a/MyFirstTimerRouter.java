package com.microservices.camel_microservice_a.routes.a;

import com.microservices.camel_microservice_a.transformation.GetCurrentTimeBean;
import com.microservices.camel_microservice_a.transformation.SimpleLoggingProcessingComponent;
import com.microservices.camel_microservice_a.transformation.SimpleLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent simpleLoggingProcessingComponent;

    @Autowired
    private SimpleLoggingProcessor simpleLoggingProcessor;

    @Override
    public void configure() throws Exception {
        //Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
        from("timer:first-timer")
                .log("${body}")
                .transform().constant("My Constant Message")
                .log("${body}")
//                .transform().constant("Time now is "+ LocalDateTime.now())
//                .bean("getCurrentTimeBean") // it's dependent on that particular class name, if it's changed than it will be unable to find it
                .bean(getCurrentTimeBean,"getCurrentTime")
                .log("${body}")
                .bean(simpleLoggingProcessingComponent)
                .log("${body}")
                .bean(simpleLoggingProcessor)
                .to("log:first-timer");

    }
}
