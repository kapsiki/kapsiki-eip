package com.kapsiki.eip.config;


import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.camel.builder.RouteBuilder;

@Configuration
public class CamelConfig {

    @Bean
    CamelContextConfiguration camelContextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                // Defining error handler route
                try {
                    camelContext.addRoutes(new RouteBuilder() {
                        @Override
                        public void configure() throws Exception {
                            errorHandler(deadLetterChannel("watcherErrorHandler"));
                        }
                    });
                } catch (Exception e) {
                    System.out.println("The exception is: " +e);
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }
}
