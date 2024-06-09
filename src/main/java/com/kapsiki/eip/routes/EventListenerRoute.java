package com.kapsiki.eip.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventListenerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:event-listener-example")
                .routeId("event-listener-example")
//                .errorHandler(deadLetterChannel("watcherErrorHandler"))
                .log(LoggingLevel.DEBUG, "Received db event: ${body}");
    }
}
