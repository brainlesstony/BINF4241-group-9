package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTimer implements Command {
    private Oven oven;

    public OvenCommandSetTimer(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute() {
        oven.setTimer();
    }

    @Override
    public String toString(){
        return "[SET TIMER]";
    }
}
