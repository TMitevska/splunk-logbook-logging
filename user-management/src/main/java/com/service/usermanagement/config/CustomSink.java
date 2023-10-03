package com.service.usermanagement.config;

import lombok.AllArgsConstructor;
import org.zalando.logbook.*;

import java.io.IOException;

@AllArgsConstructor
public final class CustomSink implements Sink {

    private final CustomJsonHttpLogFormatter formatter;
    private final HttpLogWriter writer;

    @Override
    public boolean isActive() {
        return writer.isActive();
    }

    @Override
    public void write(final Precorrelation precorrelation, final HttpRequest request) throws IOException {
        writer.write(precorrelation, formatter.format(precorrelation, request));
    }

    @Override
    public void write(final Correlation correlation, final HttpRequest request, final HttpResponse response)
            throws IOException {
        writer.write(correlation, formatter.format(correlation, request, response));
    }

}

