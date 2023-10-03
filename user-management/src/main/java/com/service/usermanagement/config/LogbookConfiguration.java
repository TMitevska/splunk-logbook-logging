package com.service.usermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.*;

@Configuration
public class LogbookConfiguration {

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .sink(new CustomSink(
                        new CustomJsonHttpLogFormatter(),
                        new DefaultHttpLogWriter()
                ))
                .build();
    }
}