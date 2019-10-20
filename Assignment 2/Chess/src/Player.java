import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Player {
    private String name;


    public Player(String name){
        this.name = name;
    }

    // TODO distinguish players in two different teams either via different color or team 1/2
    public String get_name(){
        return name;
    }

}
