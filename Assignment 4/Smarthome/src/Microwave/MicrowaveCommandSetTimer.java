package Microwave;

import Interfaces.Command;

import java.util.Scanner;

public class MicrowaveCommandSetTimer implements Command{
    private Microwave microwave;

    public MicrowaveCommandSetTimer(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        System.out.println("Set Timer: ");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();
        boolean isAllDigit= true;

        for (int i = 0; i<answer.length(); i++){
            char character = answer.charAt(i);
            if (!Character.isDigit(character)){
                isAllDigit = false;
                break;
            }
        }

        if(isAllDigit){
            int timer = Integer.parseInt(answer);
            microwave.setTimer(timer*1000);
        }
        else{
            System.out.println("Timer Input is not valid");
        }
    }

    @Override
    public String toString(){
        return "[SET TIMER]";
    }
}
