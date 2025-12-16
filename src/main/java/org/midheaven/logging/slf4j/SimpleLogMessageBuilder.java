package org.midheaven.logging.slf4j;

import org.midheaven.logging.LogMessageBuilder;

final class SimpleLogMessageBuilder implements LogMessageBuilder {

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
