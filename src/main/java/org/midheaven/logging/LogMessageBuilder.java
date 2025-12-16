package org.midheaven.logging;

public interface LogMessageBuilder {

    LogMessageBuilder withMessage(CharSequence message);
    LogMessageBuilder withParameters(Object ... parameters);
}
