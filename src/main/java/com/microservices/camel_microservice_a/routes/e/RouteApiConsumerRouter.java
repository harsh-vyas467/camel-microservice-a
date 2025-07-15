package com.microservices.camel_microservice_a.routes.e;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RouteApiConsumerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8000);

        from("timer:rest-api-consumer?period=10000")
                .log("${body}")
                .to("rest:get:/currency-exchange/from/EUR/to/INR")
                .log("${body}");
    }
}
