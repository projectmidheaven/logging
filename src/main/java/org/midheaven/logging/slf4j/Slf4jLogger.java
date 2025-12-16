package org.midheaven.logging.slf4j;

import org.midheaven.lang.Nullable;
import org.midheaven.logging.AbstractLogger;
import org.midheaven.logging.LogLevel;
import org.midheaven.logging.LoggingBuilder;
import org.slf4j.Logger;
import org.slf4j.event.Level;

class Slf4jLogger extends AbstractLogger {
    
    private final Logger logger;
    
    public Slf4jLogger(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public LoggingBuilder at(LogLevel level) {
        return new LoggingBuilder() {
            
            @Override
            public void log(String message) {
                var sLevel = toLevel(level);
                if (logger.isEnabledForLevel(sLevel)){
                    logger.atLevel(sLevel).log(message);
                }
            }
            
            @Override
            public void log(String message, Object... parameters) {
                var sLevel = toLevel(level);
                if (logger.isEnabledForLevel(sLevel)){
                    logger.atLevel(sLevel).log(message, parameters);
                }
            }
            
            @Override
            public void log(Throwable throwable, String message, Object... parameters) {
                var sLevel = toLevel(level);
                if (logger.isEnabledForLevel(sLevel)){
                    logger.atLevel(sLevel).log(message, appendThrowable(parameters, throwable));
                }
            }
        };
    }
    
    private Object[] appendThrowable(@Nullable Object[] parameters, @Nullable Throwable throwable){
        if (throwable == null){
            return parameters;
        }  else if (parameters == null || parameters.length == 0){
            return new Object[]{throwable};
        } else {
            var nArray = new Object[parameters.length + 1];
            System.arraycopy(parameters, 0 , nArray, 0, nArray.length);
            nArray[nArray.length - 1] = throwable;
            return nArray;
        }
    }
    
    @Override
    protected void write(LogLevel level, @Nullable Throwable throwable, String message, @Nullable  Object[] parameters) {
        logger.atLevel(toLevel(level)).log(message, appendThrowable(parameters, throwable));
    }
    
    private Level toLevel(LogLevel level) {
        return switch (level){
            case TRACE -> Level.TRACE;
            case DEBUG -> Level.DEBUG;
            case INFO -> Level.INFO;
            case WARN -> Level.WARN;
            case ERROR ->Level.ERROR;
        };
    }
    
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }
    
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }
    
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }
    
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }
    
    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }
}
