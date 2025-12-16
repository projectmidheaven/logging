package org.midheaven.logging.slf4j;

import org.midheaven.logging.Logger;
import org.midheaven.logging.LoggingFactory;
import org.slf4j.LoggerFactory;

public final class Sl4jLoggerFactory implements LoggingFactory {
    
    @Override
    public Logger createLogger(String category) {
        return new Slf4jLogger(LoggerFactory.getLogger(category));
    }
}