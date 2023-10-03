package com.service.usermanagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apiguardian.api.API;

import java.io.IOException;
import java.util.Map;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

@API(status = EXPERIMENTAL)
public final class CustomJsonHttpLogFormatter implements CustomStructuredHttpLogFormatter {
    private final ObjectMapper mapper;

    public CustomJsonHttpLogFormatter() {
        this(new ObjectMapper());
    }

    public CustomJsonHttpLogFormatter(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String format(final Map<String, Object> content) throws IOException {
        return this.mapper.writeValueAsString(content);
    }
}

