package org.midheaven.logging;

public final class ConsoleLoggerFactory implements LoggingFactory {

    @Override
    public Logger createLogger(String category) {
        return new ConsoleLogger(category);
    }
}

