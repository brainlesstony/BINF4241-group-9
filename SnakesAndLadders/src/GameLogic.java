import java.util.*;

public class GameLogic {

    public static void main(String[] args) {

        // BOARD
        Board board = new Board();
        board.board_message();
        board.get_board_size_from_user();
        board.make_board();
        board.set_snakes_and_ladders();

        // PLAYERS
        PlayerList playerList = new PlayerList();
        playerList.ui_player_count();
        playerList.add_player_on_board(board);

        // PLAY, ROLLING, MOVING
        board.print(); // Starting board
        Die die = new Die();
        while (!board.game_over()) { // While last square is not occupied, the game will go on
            for (Player player : playerList.get_player_list()) {
                int z = die.rollDie();
                int target = player.get_onSquare() + z;
                if (target - 1 >= board.get_board_size()) {
                    //If player goes over board_size he remains at current square
                }
                else if (!board.get_board().get(target - 1).get_isOccupied()) {
                    if (!board.check_square(target - 1).equals("Square")) {
                        if (board.check_square(target - 1).equals("Snake <-")) {
                            if (board.get_board().get(target - 1).get_isOccupied()){
                                board.get_board().get(player.get_onSquare() - 1).remove_player(player);
                                player.set_position(1);
                                board.get_board().get(0).add_player(player);
                                board.print();
                            } else {
                                special_position_update(board, target, player);
                            }
                        } else if (board.get_board().get(target - 1).get_type().equals("Ladder ->")) {
                            Square ziel = board.get_board().get(target - 1);
                            if (board.get_board().get(ziel.get_destination() - 1).get_isOccupied()) {
                                normal_position_update(board, target, player);
                            } else {
                                special_position_update(board, target, player);
                            }

                        } else if (board.get_board().get(target - 1).get_isLast()) {
                            System.out.println(player.get_name() + " rolls " + z);
                            normal_position_update(board, target, player);
                            System.out.println(player.get_name() + " has won!");
                            System.exit(0);
                        }
                    } else {
                        System.out.println(player.get_name() + " rolls " + z);
                        normal_position_update(board, target, player);

                    }
                } else {
                    System.out.println(player.get_name() + " rolls " + z);
                    normal_position_update(board, target, player);
                }
            }
        }
    }
    private static void normal_position_update(Board board, int target, Player i){
        Square ziel = board.get_board().get(target - 1); 
        board.get_board().get(i.get_onSquare() - 1).remove_player(i);
        i.set_position(ziel.get_position());
        board.get_board().get(ziel.get_position() - 1).add_player(i);
        board.print();

    }
    private static void special_position_update(Board board, int target, Player i){
        Square ziel = board.get_board().get(target - 1);
        board.get_board().get(i.get_onSquare() - 1).remove_player(i);
        i.set_position(ziel.get_destination());
        board.get_board().get(ziel.get_destination()).add_player(i);
        board.print();
    }
}
