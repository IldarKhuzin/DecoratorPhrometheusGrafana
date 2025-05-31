package org.example.Decorator;

public class UpString extends  DecorString{
    public UpString (Message message){
        super(message);
    }

    @Override
    public String getMessage(){
        return decorString.getMessage().toUpperCase();
    }
}
