package org.example.Decorator;

public class SimpleString implements Message{
    private String content;
    public SimpleString(String content){
        this.content = content;
    }

    @Override
    public String getMessage() {
        return content;
    }
}
