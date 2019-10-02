import java.util.Scanner;

public class GameLogic {

    public static void main(String[] args) {
        System.out.println("Let's start the game by first deciding on the board size!\n");
        //separat board ? numme init board im main ?
        Scanner scanner_board = new Scanner(System.in);
        System.out.println("How many squares should it have?");
        int squares = scanner_board.nextInt();
        int [] board = new int [squares];

        String[] player_names = new String[4];
        Scanner scanner_names = new Scanner(System.in);
        System.out.println("What are the players name?");

        int player_counter = 0;
        while(player_counter < 4 ) {
            String read_names = scanner_names.nextLine();
            player_names[player_counter] = read_names;
            player_counter += 1;

        }


    }
}