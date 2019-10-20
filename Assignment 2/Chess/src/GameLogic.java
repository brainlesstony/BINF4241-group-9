import java.util.ArrayList;
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
        ArrayList<Piece> [] graveyard = new ArrayList[32];

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
    private static String get_user_input(){    // This GameLogic Method will be used a lot because a move is done by a user input
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public void is_eaten(ArrayList<Piece> graveyard,Piece piece){
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
    public void print_graveyard(ArrayList<Piece> graveyard){
        String tmp;
        tmp = graveyard.toString();
    }
    public ArrayList<Piece> get_graveyard(ArrayList<Piece> graveyard){
        ArrayList<Piece> graveyard_out = new ArrayList<>();
        graveyard_out.addAll(graveyard);
        return graveyard_out;
    }

//    public void promotion (Piece piece,Board board ){
//        if (position.substring(1).equals("1") && Type.P && Color.W){
//            System.out.println("You can choose what your pawn will transform into!");
//            System.out.println("Type in one letter as indicated\n" +
//                    "Queen = Q  , Tower = T, Bishop = B, Knight = N");
//            do_promotion();
//        }
//        else if (position.substring(1).equals("") && Type.P && Color.B){
//            System.out.println("You can choose what your pawn will transform into!");
//            System.out.println("Type in one letter as indicated\n" +
//                    "Queen = Q  , Tower = T, Bishop = B, Knight = N");
//            do_promotion();
//        }
//    }
//
//    public void do_promotion() {
//        String tmp = get_user_input();
//        switch (tmp) {
//            case "Q": // remove pawn from square add queen square
//            case "T": // remove pawn from square add tower square
//            case "B": // remove pawn from square add bishop square
//            case "N": // remove pawn from square add knight square
//        }
//    }
}

