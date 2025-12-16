package org.midheaven.logging;

public class SimpleLogMessageBuilder implements LogMessageBuilder {

    String message;
    Object[] parameters;
    
    @Override
    public LogMessageBuilder withMessage(CharSequence message) {
        this.message = message.toString();
        return this;
    }

    @Override
    public LogMessageBuilder withParameters(Object... parameters) {
        this.parameters = parameters;
        return this;
    }

}
