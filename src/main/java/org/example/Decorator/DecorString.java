package org.example.Decorator;

public class DecorString implements Message{

    protected Message decorString;

    public DecorString(Message decorString){
        this.decorString = decorString;
    }

    @Override
    public String getMessage() {
        return decorString.getMessage();
    }
}

