package Oven;

import Interfaces.Command;

public class OvenCommandCheckTimer implements Command {
        private Oven oven;

        public OvenCommandCheckTimer(Oven oven){ // Tf?
            this.oven = oven;
        }

        public void execute(){
            oven.checkTimer();
        }

    @Override
    public String toString(){
        return "[CHECK TIMER]";
    }
}