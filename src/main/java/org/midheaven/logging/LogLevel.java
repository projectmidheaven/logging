package org.midheaven.logging;

public enum LogLevel  {

    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR;

    public boolean isEnabledAt(Logger logger) {
        return switch (this){
            case TRACE -> logger.isTraceEnabled();
            case DEBUG -> logger.isDebugEnabled();
            case INFO -> logger.isInfoEnabled();
            case WARN -> logger.isWarnEnabled();
            case ERROR -> logger.isErrorEnabled();
        };
    }
}
