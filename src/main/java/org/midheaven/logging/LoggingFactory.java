package org.midheaven.logging;

public interface LoggingFactory {

    Logger createLogger(String category);
}
