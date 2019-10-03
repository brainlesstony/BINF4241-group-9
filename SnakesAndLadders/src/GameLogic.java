import java.util.Arrays;
import java.util.Scanner;


public class GameLogic {
    // private Die die = new Die(); // I don`t know where the die should be initialized.
    // int z = die.rollDie();

    public static void main(String[] args) {
        System.out.println("Let's start the game by first deciding on the board size!\n");
        System.out.println("What would you like the board size to be?");
        Scanner scanner_board = new Scanner(System.in);
        int board_size = scanner_board.nextInt();
        int [] board = new int[board_size]; // board size begrenzung ? min ? max ?
        for( int i = 1; i <= board_size; i++)
            board[i-1] = i; // square object noch anfügen
                            // wo sind snakes und ladders?

        String[] player_names = new String[4];
        Scanner scanner_names = new Scanner(System.in);
        System.out.println("How many players are playing?");
        Scanner scanner_name_num = new Scanner(System.in);
        //muss grösser als 2 sein
        System.out.println("What are the players name?");

        int player_counter = 0;
        while(player_counter < 4 ) {
            String read_names = scanner_names.nextLine();
            player_names[player_counter] = read_names;
            player_counter += 1;
            //Erster Spieler aus der Liste ziehen
            // Wieder hinten anfügen


        }


    }
}