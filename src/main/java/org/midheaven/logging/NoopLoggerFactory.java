package org.midheaven.logging;

import org.midheaven.lang.NotNullable;

import java.util.function.Consumer;

public final class NoopLoggerFactory implements LoggingFactory {

    private static final NoopLogger LOGGER = new NoopLogger();
    
    @Override
    public Logger createLogger(String category) {
        return new NoopLogger();
    }
}

class NoopLogger implements Logger {
    
    
    @Override
    public LoggingBuilder at(LogLevel level) {
        return new LoggingBuilder() {
            @Override
            public void log(@NotNullable String message) {
            
            }
            
            @Override
            public void log(@NotNullable String message, @NotNullable Object... parameters) {
            
            }
            
            @Override
            public void log(@NotNullable Throwable throwable, @NotNullable String message, @NotNullable Object... parameters) {
            
            }
        };
    }
    
    @Override
    public boolean isTraceEnabled() {
        return false;
    }
    
    @Override
    public void trace(String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void trace(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public void trace(Throwable throwable, String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void trace(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public boolean isDebugEnabled() {
        return false;
    }
    
    @Override
    public void debug(String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void debug(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public boolean isInfoEnabled() {
        return false;
    }
    
    @Override
    public void info(String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void info(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public boolean isWarnEnabled() {
        return false;
    }
    
    @Override
    public void warn(String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void warn(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public void warn(Throwable throwable, String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void warn(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public boolean isErrorEnabled() {
        return false;
    }
    
    @Override
    public void error(String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void error(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
    
    @Override
    public void error(Throwable throwable, String message, Object... parameters) {
        //no-op
    }
    
    @Override
    public void error(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        //no-op
    }
}
