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
        board.fake_flush();
        board.print();

        while(true){ //!mover.checkmate()
            /////////////player 1
            System.out.println(player1.get_name() + ", it's your turn to play. Please choose your figure:");
            player1_input1 = get_user_input();
            while (!board.valid_input(player1_input1)){
                System.out.println("Input not valid! Try again!");
                player1_input1 = get_user_input();
            }
            while (mover.cannot_move(player1_input1, board)){
                System.out.println("Can`t move! Try again: ");
                player1_input1 = get_user_input();
            }
            while (mover.is_defended(player1_input1, board)) {
                System.out.println("Protect your king with your body (Dont move away!). Try again: ");
                player1_input1 = get_user_input();
            }
            // //CHECK If the selected piece can actually move from its position
            while (board.valid_turn(player1, board.get_Piece_from_position(player1_input1))){
                // Wenn de player nid dra isch den wird er nomol gfrogt bis er mol cheggt het das er en validi figur gwählt het.
                // oder er het en feld usgewählt wo gar nix drufe isch
                    System.out.println("Not possible figure. Try again: ");
                    player1_input1 = get_user_input();
            }
//            System.out.println("You have choosen" + board.get_Piece_from_position(player1_input1) + "from Square " + "\'"+ player1_input1 + "\'");
            System.out.println(player1.get_name() + ", it's your turn to play. Please choose your destination:");
            player1_input2 = get_user_input();

            while (!mover.move_check(player1_input1, player1_input2, board)){
                System.out.println("invalid Destination. Try again: ");
                player1_input2 = get_user_input();
            }
            board.move(player1_input1, player1_input2);
            mover.is_promotion(board,player1_input2);
            board.fake_flush();
            mover.is_check(board);
            board.print();


            ////////////player2
            // Welche Figur bestimmt durch User Input des Feldes
            System.out.println(player2.get_name() + ", it's your turn to play. Please choose your figure:");
            player2_input1 = get_user_input();
            while (!board.valid_input(player2_input1)){
                System.out.println("Input not valid! Try again!");
                player2_input1 = get_user_input();
            }
            while (mover.cannot_move(player2_input1, board)){
                System.out.println("Can`t move! Try again: ");
                player2_input1 = get_user_input();
            }
            while (mover.is_defended(player2_input1, board)) {
                System.out.println("Protect your king with your body (Dont move away!). Try again: ");
                player2_input1 = get_user_input();
            }
            while (board.valid_turn(player2, board.get_Piece_from_position(player2_input1))) {
                System.out.println("Not possible figure. Try again: ");
                player2_input1 = get_user_input();
            }
//            System.out.println("You have choosen" + board.get_Piece_from_position(player2_input1) + "from Square " + "\'"+ player2_input1 + "\'");
            System.out.println(player2.get_name() + ", it's your turn to play. Please choose your destination:");
            player2_input2 = get_user_input();
            while (!mover.move_check(player2_input1,player2_input2,board)){
                System.out.println("invalid Destination. Try again: ");
                player2_input2 = get_user_input();
            }
            board.move(player2_input1, player2_input2);
            mover.is_promotion(board,player2_input2);
            board.fake_flush();
            mover.is_check(board);
            board.print();
        }
    }

    public static String get_user_input(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    private static String name_from_player() {
        String line;
        Scanner input = new Scanner(System.in);
        line = input.nextLine();
        if (line.equals("") || line == null) {
            System.out.println("Please insert a name next time ;-)");
            System.out.println("Thank you");
            System.exit(0);
            return null;
        }
        else {
            return line;
        }
    }
}

