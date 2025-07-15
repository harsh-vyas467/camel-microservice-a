package com.microservices.camel_microservice_a.routes.d;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class KafkaSenderJsonRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//          to send file to kafka
        from("file:files/json")
                .log("${body}")
                .to("kafka:myKafkaTopic");
    }
}
