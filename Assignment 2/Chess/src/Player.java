import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }

    public void name_from_player(){
        System.out.println("Player name: ");
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();

    }

    public String get_name(){
        return name;
    }

}
