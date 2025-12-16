package org.midheaven.logging;

import org.midheaven.lang.ValueClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DeferredLoggerFactory implements LoggingFactory {
    
    private final LoggingFactory realLoggingFactory;
    private final Map<String, Logger> realLoggers = new ConcurrentHashMap<>();
    
    public DeferredLoggerFactory(
        LoggingFactory realLoggingFactory
    ){
        this.realLoggingFactory = realLoggingFactory;
    }
    
    @Override
    public Logger createLogger(String category) {
        return new DeferredLogger(category);
    }
    
    @ValueClass
    final class DeferredLogger extends AbstractLogger {
        
        private final String category;
        
        public DeferredLogger(String category) {
            this.category = category;
        }
        
        @Override
        protected void write(LogLevel level, Throwable throwable, String message, Object[] parameters) {
            var logger = realLoggers.computeIfAbsent(category, DeferredLoggerFactory.this.realLoggingFactory::createLogger);
            if (logger instanceof AbstractLogger writableLogger){
                writableLogger.write(level,throwable, message, parameters);
            } else {
               logger.at(level).log(throwable, message, parameters);
            }
        }
        
      
    }
    
}
