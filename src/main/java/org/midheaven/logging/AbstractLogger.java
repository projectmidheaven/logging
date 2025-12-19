package org.midheaven.logging;

import org.midheaven.lang.Check;
import org.midheaven.lang.NotNullable;
import org.midheaven.lang.Nullable;

import java.util.function.Consumer;

public abstract class AbstractLogger implements Logger{

    private void log(LogLevel level, Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer){
        if(level.isEnabledAt(this)){
            var builder = new SimpleLogMessageBuilder();
            deferedMessageConsumer.accept(builder);
            write(level, throwable, builder.message, builder.parameters);
        }
    }

    protected abstract void write(@NotNullable LogLevel level, @Nullable Throwable throwable,@NotNullable String message, @Nullable Object[] parameters);
    
    @Override
    public LoggingBuilder at(LogLevel level) {
        Check.argumentIsNotNull(level);
        return new LoggingBuilder() {
            
            @Override
            public void log(String message) {
                Check.argumentIsNotNull("message", message);
                if(level.isEnabledAt(AbstractLogger.this)){
                    write(level, null,message, null );
                }
            }
            
            @Override
            public void log(String message, Object... parameters) {
                Check.argumentIsNotNull( message, "message");
                Check.argumentIsNotNull(parameters, "parameters");
                if(level.isEnabledAt(AbstractLogger.this)){
                    write(level, null,message, parameters );
                }
            }
            
            @Override
            public void log(Throwable throwable, String message, Object... parameters) {
                Check.argumentIsNotNull(throwable, "throwable");
                Check.argumentIsNotNull(message, "message");
                Check.argumentIsNotNull(parameters, "parameters");
                if(level.isEnabledAt(AbstractLogger.this)){
                    write(level, throwable,message, parameters );
                }
            }
        };
    }
    
    @Override
    public void trace(String message, Object... parameters) {
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.TRACE, null, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void trace(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.TRACE, null, deferedMessageConsumer);
    }

    @Override
    public void trace(Throwable throwable, String message, Object... parameters) {
        Check.argumentIsNotNull(throwable, "throwable");
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.TRACE, throwable, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void trace(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull( throwable, "throwable");
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.TRACE, throwable, deferedMessageConsumer);
    }
    
    @Override
    public void debug(String message, Object... parameters) {
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.DEBUG, null, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void debug(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.DEBUG, null, deferedMessageConsumer);
    }


    @Override
    public void info(String message, Object... parameters) {
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.INFO, null, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void info(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.INFO, null, deferedMessageConsumer);
    }


    @Override
    public void warn(String message, Object... parameters) {
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.WARN, null, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void warn(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.WARN, null, deferedMessageConsumer);
    }

    @Override
    public void warn(Throwable throwable, String message, Object... parameters) {
        Check.argumentIsNotNull(throwable, "throwable");
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.WARN, throwable, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void warn(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull( throwable, "throwable");
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.WARN, throwable, deferedMessageConsumer);
    }

    @Override
    public void error(String message, Object... parameters) {
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.ERROR, null, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void error(Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.ERROR, null, deferedMessageConsumer);
    }

    @Override
    public void error(Throwable throwable, String message, Object... parameters) {
        Check.argumentIsNotNull(throwable, "throwable");
        Check.argumentIsNotNull(message, "message");
        Check.argumentIsNotNull(parameters, "parameters");
        log(LogLevel.ERROR, throwable, builder -> builder.withMessage(message).withParameters(parameters));
    }

    @Override
    public void error(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer) {
        Check.argumentIsNotNull( throwable, "throwable");
        Check.argumentIsNotNull(deferedMessageConsumer, "deferedMessageConsumer");
        log(LogLevel.ERROR, throwable, deferedMessageConsumer);
    }
    
    @Override
    public boolean isTraceEnabled() {
        return LoggingConfiguration.loggingLevel.compareTo(LogLevel.TRACE) == 0;
    }
    
    @Override
    public boolean isDebugEnabled() {
        return LoggingConfiguration.loggingLevel.compareTo(LogLevel.DEBUG) <= 0;
    }
    
    @Override
    public boolean isInfoEnabled() {
        return LoggingConfiguration.loggingLevel.compareTo(LogLevel.INFO) <= 0;
    }
    
    @Override
    public boolean isWarnEnabled() {
        return LoggingConfiguration.loggingLevel.compareTo(LogLevel.INFO) <= 0;
    }
    
    @Override
    public boolean isErrorEnabled() {
        return LoggingConfiguration.loggingLevel.compareTo(LogLevel.ERROR) <= 0;
    }
}
