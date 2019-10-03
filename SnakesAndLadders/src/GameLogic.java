import java.util.Arrays;
import java.util.Scanner;


public class GameLogic {
    // private Die die = new Die(); // I don`t know where the die should be initialized.
    // int z = die.rollDie();

    public static void main(String[] args) {

        // BOARD
        System.out.println("Let's start the game by first deciding on the board size!\n");
        System.out.println("What would you like the board size to be?");

        Scanner scanner_board = new Scanner(System.in);
        int board_size = scanner_board.nextInt();
        int [] board = new int[board_size]; // board size begrenzung ? min ? max ?
        for( int i = 1; i <= board_size; i++){
            board[i-1] = i; // square object noch anfügen
                            // wo sind snakes und ladders?
        }
        // PLAYER INPUT
        System.out.println("How many players are playing?");
        Scanner scanner_name_num = new Scanner(System.in);
        int player_count = scanner_name_num.nextInt();

        if (player_count < 2 || player_count > 4){
            System.out.println("Sorry, this game can only be played by 2-4 players");
            System.exit(0);
        }


        Player [] thePlayer = new Player[player_count];
        System.out.println("What are the players name?");
        //Scanner player_name = new Scanner(System.in);


        //for (int i = 0; i <= player_count-1; i++){
            //thePlayer[i] = player_names[i];
        //}

        String[] player_names = new String[player_count];
        int temp_count = player_count;
        while(temp_count > 0 ) {
            Scanner player_name = new Scanner(System.in);
            String read_names = player_name.nextLine();
            player_names[temp_count-1] = read_names;
            temp_count -= 1;
            //thePlayer[player_count] =
        }
        // FIRST TURN

        //Erster Spieler aus der Liste ziehen
        // Wieder hinten anfügen

    }
}