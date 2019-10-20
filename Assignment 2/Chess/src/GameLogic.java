import java.util.List;
import java.util.Scanner;
public class GameLogic {

    public static void main(String[] args){
        //BOARD & PLAYER
        Board board = new Board(); // creates a board with the figures
        System.out.println("Player 1 will play as white and Player 2 plays as black");
        System.out.println("Player names: ");
        Player player1 = new Player(name_from_player());
        Player player2 = new Player(name_from_player());
        board.print();
        List [] graveyard = new List[32];
        //TODO When player gets to promotion field(start field of the enemy) \n
        // He gets to change his piece pawn into a new piece
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

    public void is_eaten(List graveyard,Piece piece){
        graveyard.add(piece);
    }
    private static String name_from_player() {
        String line;
        Scanner input = new Scanner(System.in);
        line = input.nextLine();
        if (line.equals("") || line == null) {
            System.exit(0);
            return null;
        }
        else {
            return line;
        }
    }
}

