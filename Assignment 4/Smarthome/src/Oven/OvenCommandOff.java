package Oven;
import Interfaces.Command;
public class OvenCommandOff implements Command {
    private Oven oven;

    public OvenCommandOff(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute(){

        if (this.oven.getProgram() == Program_oven.Done) {
            oven.off();
        }
        else{
            System.out.println("Program must be finished first!");
        }
    }

    @Override
    public String toString(){
        return "[OFF]";
    }
}
