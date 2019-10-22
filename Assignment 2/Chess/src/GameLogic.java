import java.util.ArrayList;
import java.util.Scanner;
public class GameLogic {

    public static void main(String[] args){
        //BOARD & PLAYER
        String player1_input1;
        String player1_input2;
        String player2_input1;
        String player2_input2;
        Board board = new Board(); // creates a board with the figures
        Move mover = new Move();
        System.out.println("Player 1 will play as white and Player 2 plays as black");
        System.out.println("Player names: ");
        Player player1 = new Player(name_from_player(), Color.W);
        Player player2 = new Player(name_from_player(), Color.B);
        board.print();
        board.print();

        while(true){
            /////////////player 1
            System.out.println(player1.get_name() + ", Sie sind dran. Bitte wählen Sie ihre Figur:");
            player1_input1 = get_user_input();
            while (board.valid_turn(player1, board.get_Piece_from_position(player1_input1))) {
                // Wenn de player nid dra isch den wird er nomol gfrogt bis er mol cheggt het das er en validi figur gwählt het.
                // oder er het en feld usgewählt wo gar nix drufe isch
                System.out.println("Not possible figure. Try again: ");
                player1_input1 = get_user_input();
            }
            System.out.println(player1.get_name() + ", Sie sind dran. Bitte wählen Sie das Zielfeld:");
            player1_input2 = get_user_input();
            /*while (!board.valid_input(player1_input2) && !mover.move_check(player1_input1, player1_input2, board.getBoard())){
            this should also check if the the move is a valid move like when a pawn wants to jump like a queen it should ask for a new destination again.
            but doesnt work yet
            * */
            while (!mover.move_check(player1_input1,player1_input2,board)){
                System.out.println("invalid Destination. Try again: ");
                player1_input2 = get_user_input();
            }
            if (mover.move_check(player1_input1, player1_input2, board)){
                board.move(player1_input1, player1_input2);
            }
            board.print();

            ////////////player2
            System.out.println(player2.get_name() + ", Sie sind dran. Bitte wählen Sie ihre Figur:");
            player2_input1 = get_user_input();
            while (board.valid_turn(player2, board.get_Piece_from_position(player2_input1))) {
                System.out.println("Not possible figure. Try again: ");
                player2_input1 = get_user_input();
            }
            System.out.println(player2.get_name() + ", Sie sind dran. Bitte wählen Sie das Zielfeld:");
            player2_input2 = get_user_input();
            while (!mover.move_check(player2_input1,player2_input2,board)){
                System.out.println("invalid Destination. Try again: ");
                player2_input2 = get_user_input();
            }
            if (mover.move_check(player2_input1, player2_input2, board)){ // funktioniert nicht
                board.move(player2_input1, player2_input2);
            }
            board.print();
        }

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

    private static String get_user_input(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    private static String name_from_player() {
        String line;
        Scanner input = new Scanner(System.in);
        line = input.nextLine();
        if (line.equals("") || line == null) {
            System.out.println("Please insert a name next time ;)");
            System.out.println("Thank you");
            System.exit(0);
            return null;
        }
        else {
            return line;
        }
    }
    public void print_graveyard(ArrayList<Piece> graveyard){
        String tmp;
        tmp = graveyard.toString();
    }


    public ArrayList<Piece> get_graveyard(ArrayList<Piece> graveyard){
        ArrayList<Piece> graveyard_out = new ArrayList<>();
        graveyard_out.addAll(graveyard);
        return graveyard_out;
    }

}

