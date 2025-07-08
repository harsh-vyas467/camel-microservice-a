package com.microservices.camel_microservice_a.transformation;

import ch.qos.logback.classic.Logger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessor implements Processor {

    private Logger logger= (Logger) LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    @Override
    public void process(Exchange exchange) throws Exception {

//        logger.info("SimpleLoggingProcessor {}", exchange);
        logger.info("SimpleLoggingProcessor {}", exchange.getMessage().getBody());

    }
}
