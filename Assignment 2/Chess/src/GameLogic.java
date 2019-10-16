import java.util.Scanner;
public class GameLogic {

    private static String get_user_input(){    // This GameLogic Method will be used a lot because a move is done by a user input
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void main(String[] args){
        //BOARD & PLAYER
        Board board = new Board(); // creates a board with the figures
        System.out.println("Player name: ");
        Player player1 = new Player(get_user_input());
        Player player2 = new Player(get_user_input());
        board.print();

        /*
        while (!board.checkmate()) {
            board.print(); // prints the board and also the eaten figures
            board.move(get_user_input()); // from player1
            board.flush();
            board.print();
            board.move(get_user_input()); // from player2
            board.flush(); // This method should clear the console after the move was done (Terminal not Intellij Console)

        }
         */
    }
}

