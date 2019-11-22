package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTemperature implements Command {
    private Oven oven;

    public OvenCommandSetTemperature(Oven oven){
        this.oven = oven;
    }

    public void execute() {
        oven.setTemperature();
    }

    @Override
    public String toString(){
        return "[SET TEMPERATURE]";
    }
}
