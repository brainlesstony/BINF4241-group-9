import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Player {
    private String name;
    private Color color;


    public Player(String aname, Color acolor){
        this.name = aname;
        this.color = acolor;
    }

    // TODO distinguish players in two different teams either via different color or team 1/2
    public String get_name(){
        return name;
    }
    public Color get_color(){return color;}
}
