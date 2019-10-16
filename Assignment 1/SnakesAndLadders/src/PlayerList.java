import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerList {
    private List<Player> playerList;
    private int player_count;

    public PlayerList(){
        this.playerList = new ArrayList<Player>();
        this.player_count = 0;
    }
    public int get_player_count(){
        return player_count;
    }
    public void ui_player_count(){
        System.out.println("How many players are playing (2-4)?");
        Scanner scanner_name_num = new Scanner(System.in);
        int player_count_fu = scanner_name_num.nextInt(); // fu = from user
        if (player_count_fu < 2 || player_count_fu > 4){
            System.out.println("Sorry, this game can only be played by 2-4 players");
            System.exit(0);
        }
        player_count = player_count_fu;
    }
    public void add_player_on_board(Board board){
        System.out.println("What are the " + player_count + " players name? ");
        Scanner player_name = new Scanner(System.in); // creates Scanner
        for (int i = 1; i <= player_count; i++){
            System.out.print("Player " + i + ": ");
            String read_names = player_name.nextLine(); // reads User Input
            Player new_player = new Player(read_names);
            get_player_list().add(new_player);
            board.get_board().get(0).add_player(new_player);
        }
    }
    public List<Player> get_player_list(){
        return playerList;
    }

}
