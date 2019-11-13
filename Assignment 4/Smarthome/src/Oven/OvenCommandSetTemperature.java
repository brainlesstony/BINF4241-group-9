package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTemperature implements Command {
    Oven oven;
    public void execute() {
        System.out.println("Set Temperature: ");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();

        for (int i = 0; i < answer.length(); i++) {
            char character = answer.charAt(i);
            if (!Character.isDigit(character)) {
                //fail and break
            }
        }

        int temperature = Integer.parseInt(answer);

        if (temperature < 100 || temperature > 250) {
            //fail
        }

        oven.setTemperature(temperature);
    }
}
