package org.midheaven.logging;

import org.midheaven.lang.NotNullable;
import org.midheaven.lang.Nullable;

class ConsoleLogger extends AbstractLogger {
    
    private final String category;
    
    public ConsoleLogger(String category) {
        this.category = category;
    }
    
    @Override
    protected void write(@NotNullable LogLevel level, @Nullable Throwable throwable, @NotNullable String message, @Nullable Object[] parameters) {
        System.out.append(category).append(' ')
            .append('[').append(level.name()).append(']').append(' ')
            .append(interpolate(message, parameters));
        
        if (throwable != null) {
            System.out.append(':')
                .println();
            throwable.printStackTrace(System.out);
        } else {
            System.out.println();
        }
    }
    
    private String interpolate(String message, @Nullable Object[] parameters){
        if (parameters!= null && parameters.length > 0){
            var builder = new StringBuilder();
            var pos = message.indexOf("{}");
            var previousPos = 0;
            var counter = 0;
            while (pos >= 0){
                var text = message.substring(previousPos, pos);
                builder.append(text);
                builder.append(parameters[counter++]);
                previousPos = pos + 2;
                pos = message.indexOf("{}", previousPos);
            }
            return builder.toString();
        }
        return message;
    }
}
