package org.midheaven.logging;

import org.midheaven.lang.NotNullable;

public interface LoggingBuilder {
    
    void log(@NotNullable String message);
    void log(@NotNullable String message,@NotNullable Object ... parameters);
    void log(@NotNullable Throwable throwable,@NotNullable String message, @NotNullable Object... parameters);
    
}
