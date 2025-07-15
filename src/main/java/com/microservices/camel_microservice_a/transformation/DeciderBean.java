package com.microservices.camel_microservice_a.transformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeciderBean {
    Logger logger = LoggerFactory.getLogger(DeciderBean.class);

    public boolean isThisConditionMet(String body){
        logger.info("Decider bean {}", body);
        return true;
    }
}
