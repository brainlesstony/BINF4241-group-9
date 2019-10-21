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
            Color playing_color;
            //player 1
            playing_color = Color.W;
            System.out.println(player1.get_name() + ", Sie sind dran. Bitte wählen Sie ihre Figur:");
            player1_input1 = get_user_input();
            System.out.println(player1.get_name() + ", Sie sind dran. Bitte wählen Sie das Zielfeld:");
            player1_input2 = get_user_input();
            if (mover.move_check(player1_input1, player1_input2, board.getBoard())){
                board.move(player1_input1, player1_input2);
            }
            board.print();
            //player2
            playing_color = Color.B;
            System.out.println(player2.get_name() + ", Sie sind dran. Bitte wählen Sie ihre Figur:");
            player2_input1 = get_user_input();
            System.out.println(player2.get_name() + ", Sie sind dran. Bitte wählen Sie das Zielfeld:");
            player2_input2 = get_user_input();
            if (mover.move_check(player2_input1, player2_input2, board.getBoard())){ // funktioniert nicht
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
            System.out.println("Please insert a name next time not an empty string");
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

