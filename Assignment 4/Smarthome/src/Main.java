import Dishwasher.Dishwasher;
import Oven.Oven;
import Washing_Machine.Washing_Machine;
import Cleaning_Robot.Cleaning_Robot;
import Microwave.Microwave;
public class Main {
    public static void main(String args[]){
        // INIT ALL OBJECTS
        Oven oven = new Oven();
        Washing_Machine washing_machine = new Washing_Machine();
        Microwave microwave = new Microwave();
        Cleaning_Robot cleaning_robot = new Cleaning_Robot();
        Dishwasher dishwasher = new Dishwasher();
        Smartphone smartphone = new Smartphone();
        //MAYBE ASK USER FOR # of OBJECTS GIVE THEM POSSIBLITY TO ADD OR REMOVE WHENEVER
        System.out.println(oven);
    }
}
