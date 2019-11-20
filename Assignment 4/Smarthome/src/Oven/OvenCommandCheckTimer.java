package Oven;

import Interfaces.Command;

public class OvenCommandCheckTimer implements Command {
        private Oven oven;

        public OvenCommandCheckTimer(Oven oven){ // Tf?
            this.oven = oven;
        }

        public void execute(){

            if(this.oven.getProgram() != Program_oven.Done){
                System.out.println("Time left: " + (System.currentTimeMillis()-this.oven.getStartTime()));
            }
            else{
                System.out.println("No active program. Last active timer was: " + this.oven.getTimer());
            }
        }
}

