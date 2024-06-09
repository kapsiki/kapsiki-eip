package com.kapsiki.eip.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InitRoute extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(InitRoute.class);

    @Override
    public void configure() throws Exception {
        logger.info("Configuring InitRoute...");
        from("scheduler:test?initialDelay=500&repeatCount=1")
                .routeId("example")
                .to("openmrs-watcher:example");
        logger.info("InitRoute configured successfully.");
    }
}
