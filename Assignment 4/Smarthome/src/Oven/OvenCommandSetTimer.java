package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTimer implements Command {
    Oven oven;
    public void execute() {
        System.out.println("Set Timer: ");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();

        for (int i = 0; i< answer.length(); i++){
            char character = answer.charAt(i);
            if (!Character.isDigit(character)){
                //fail and break
            }
        }

        int timer = Integer.parseInt(answer);

        if (timer <0){
            //fail
        }

        oven.setTimer(timer);
    }
}
