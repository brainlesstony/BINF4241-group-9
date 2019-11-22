package Microwave;

import Interfaces.Command;

import java.util.Scanner;

public class MicrowaveCommandSetTemperature implements Command{
    private Microwave microwave;

    public MicrowaveCommandSetTemperature(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.setTemperature();
    }

    @Override
    public String toString(){
        return "[SET TEMPERATURE]";
    }
}
