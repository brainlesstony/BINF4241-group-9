package Oven;

import Interfaces.Command;

import java.util.Scanner;

public class OvenCommandSetTemperature implements Command {
    private Oven oven;

    public OvenCommandSetTemperature(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute() {
        System.out.println("Set Temperature: ");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();
        boolean isAllDigit = true;
        for (int i = 0; i < answer.length(); i++) {
            char character = answer.charAt(i);
            if (!Character.isDigit(character)) {
                isAllDigit = false;
                break;
            }
        }

        int temperature = Integer.parseInt(answer);

        if (temperature >= 100 && temperature <= 250 && isAllDigit) {
            oven.setTemperature(temperature);
        }
        else{
            System.out.println("Input not allowed! Temperature is not valid!");
        }
    }
}
