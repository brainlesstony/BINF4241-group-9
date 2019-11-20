package Cleaning_Robot;
import Interfaces.Machine;

public class Cleaning_Robot implements Machine{
    private boolean state;
    private int timer;
    private int battery_status;
    private int elapsed;

    public Cleaning_Robot() {
        this.state = false;
        this.timer = 0;
        this.battery_status = 100;
        this.elapsed = 0;
    }
        public void on () {
            this.state = true;
            System.out.println("Cleaning Robot is turned on.");
        }

        public void off () {
            this.state = false;
            System.out.println("Cleaning Robot is turned off.");
        }

        void setTimer () {
            this.timer = 60;
            System.out.println("Timer is set.");
        }

        int get_battery_status () {
            return this.battery_status;
        }

        void start_cleaner () {
            if (get_battery_status() == 100) {
                System.out.println("Started the vacuum cleaner.");
            } else {
                System.out.println("Battery status too low.");
            }
        }

        int get_cleaning_rate () {
            return this.elapsed / this.timer;
        }


//    private Command [] getCommands(){
//        return new Command[]{Cleaning_RobotCommandOn,Cleaning_RobotCommandOff,Cleaning_RobotSetTimer};
}

