package Microwave;

import Interfaces.Command;

import java.util.Scanner;

public class MicrowaveCommandSetTimer implements Command{
    private Microwave microwave;

    public MicrowaveCommandSetTimer(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
       microwave.setTimer();
    }

    @Override
    public String toString(){
        return "[SET TIMER]";
    }
}
