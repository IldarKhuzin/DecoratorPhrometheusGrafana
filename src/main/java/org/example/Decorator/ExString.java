package org.example.Decorator;

public class ExString  extends DecorString{
    public ExString (Message message){
        super(message);
    }

    @Override
    public String getMessage(){
        return decorString.getMessage() + " !!!";
    }
}
