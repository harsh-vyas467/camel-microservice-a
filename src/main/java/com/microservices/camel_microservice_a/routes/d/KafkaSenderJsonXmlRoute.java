package com.microservices.camel_microservice_a.routes.d;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderJsonXmlRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//          to send file to kafka
        from("file:files/input")
                .routeId("Files-Input_Route")
                .transform().body(String.class)
                .choice()
                    .when(simple("${file:ext} ends with 'xml'"))
                        .log("XML File")
                    .when(simple("${body} contains 'USD'"))
                        .log("Not an xml file but contains USD")
                    .otherwise()
                    .log("Not an XML File")
                .end()
                .log("${body}")
                .to("direct://log-file-values")
                .to("kafka:myKafkaTopic");


        // creating reusable endpoints in camel routes

        from("direct:log-file-values")
                .log("${messageHistory}  ${file:absolute.path}")
                .log("This is a message from reusable endpoint");
    }
}
