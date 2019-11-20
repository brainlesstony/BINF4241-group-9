package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTimer implements Command {
    private Oven oven;

    public OvenCommandSetTimer(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute() {
        System.out.println("Set Timer in seconds: ");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();
        boolean isAllDigit = true;

        for (int i = 0; i< answer.length(); i++){
            char character = answer.charAt(i);
            if (!Character.isDigit(character)){
                isAllDigit = false;
                break;
            }
        }

        if (isAllDigit){
            int timer = Integer.parseInt(answer);
            oven.setTimer(1000*timer);
        }
        else{
            System.out.println("Timer Input not valid");
        }
    }
}
