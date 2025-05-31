package org.example.DecoratorTest;

import org.example.Decorator.ExString;
import org.example.Decorator.Message;
import org.example.Decorator.SimpleString;
import org.example.Decorator.UpString;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public  class DecoratorTest {

    @Test
    void testSimpleString() {
        Message message = new SimpleString("hello");
        assertEquals("hello", message.getMessage());
    }

    @Test
    void testUpString() {
        Message message = new UpString(new SimpleString("hello"));
        assertEquals("HELLO", message.getMessage());
    }

    @Test
    void testExString() {
        Message message = new ExString(new SimpleString("hello"));
        assertEquals("hello !!!", message.getMessage());
    }

    @Test
    void testUpAndExCombined() {
        Message message = new ExString(new UpString(new SimpleString("hello")));
        assertEquals("HELLO !!!", message.getMessage());
    }

    @Test
    void testExAndUpCombined() {
        Message message = new UpString(new ExString(new SimpleString("hello")));
        assertEquals("HELLO !!!", message.getMessage());
    }

    @Test
    void testMultipleDecorators() {
        Message message = new ExString(new ExString(new UpString(new SimpleString("wow"))));
        assertEquals("WOW !!! !!!", message.getMessage());
    }
}