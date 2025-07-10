package com.microservices.camel_microservice_a.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderJsonRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // to put regular messages on que
//        from("timer:active-mq-timer?period=10000")
//                .transform().constant("My message for Active MQ")
//                .log("${body}")
//                .to("activemq:my-activemq-queue");

//          to send file to activemq
        from("file:files/json")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
