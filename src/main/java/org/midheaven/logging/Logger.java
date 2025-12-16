package org.midheaven.logging;

import java.util.function.Consumer;

/**
 * Loggin main interface
 */
public interface Logger {
    
    /**
     * Request a logger for the given class. The class completely qualified name will be used as the Logger's category
     * @param type the class type
     * @return a Logger for the class' category
     */
    static Logger of(Class<?> type){
        return of(type.getName());
    }
    
    /**
     * Request a logger for the given category. The category can be a dot separated name for hierarchical categories.
     * @param category the category
     * @return a Logger for the category
     */
    static Logger of(String category){
        return LoggingConfiguration.loggingFactory.createLogger(category);
    }

    LoggingBuilder at(LogLevel level);
    
    boolean isTraceEnabled();
    void trace(String message, Object ... parameters);
    void trace(Consumer<LogMessageBuilder> deferedMessageConsumer);
    void trace(Throwable throwable, String message, Object ... parameters);
    void trace(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer);

    boolean isDebugEnabled();
    void debug(String message, Object ... parameters);
    void debug(Consumer<LogMessageBuilder> deferedMessageConsumer);

    boolean isInfoEnabled();
    void info(String message, Object ... parameters);
    void info(Consumer<LogMessageBuilder> deferedMessageConsumer);

    boolean isWarnEnabled();
    void warn(String message, Object ... parameters);
    void warn(Consumer<LogMessageBuilder> deferedMessageConsumer);
    void warn(Throwable throwable, String message, Object ... parameters);
    void warn(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer);

    boolean isErrorEnabled();
    void error(String message, Object ... parameters);
    void error(Consumer<LogMessageBuilder> deferedMessageConsumer);
    void error(Throwable throwable, String message, Object ... parameters);
    void error(Throwable throwable, Consumer<LogMessageBuilder> deferedMessageConsumer);

}
