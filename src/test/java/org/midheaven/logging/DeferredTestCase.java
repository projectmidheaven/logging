package org.midheaven.logging;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeferredTestCase {
    
    TestLoggerFactory factory = new TestLoggerFactory();
    
    @BeforeAll
    public void setUp(){
        LoggingConfiguration.setFactory(new DeferredLoggerFactory(factory));
    }
    
    @Test
    public void deferringIsConsistent(){
        // create logger
        Logger logger = Logger.of("samples");
        
        // no real logger was created
        assertEquals(0,factory.counter);
        
        // use the logger
        logger.warn("test");
        
        // the real logger was created
        assertEquals(1,factory.counter);
    }
}


class TestLoggerFactory implements LoggingFactory{
    
    public int counter;
    
    @Override
    public Logger createLogger(String category) {
        counter++;
        return new NoopLogger();
    }
}