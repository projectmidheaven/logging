package org.midheaven.logging;

public class LoggingConfiguration {

    static LoggingFactory loggingFactory = new NoopLoggerFactory();
    static LogLevel loggingLevel = LogLevel.TRACE;

    public static void setFactory(LoggingFactory factory){
        loggingFactory = factory;
    }
    
    public static void setLevel(LogLevel level){
        loggingLevel = level;
    }
}
