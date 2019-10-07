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
        Die die = new Die();
        String winner = null;
        while (!board.game_over()) { // While last square is not occupied, the game will go on
            for (Player player : playerList.get_player_list()) {
                if (board.game_over()){
                    System.out.println(board.get_board() + "\n" + winner + " wins");
                    System.exit(0);
                }
                winner = player.get_name();
                int z = die.rollDie();
                board.print(player, z);
                int target = player.get_pos() + z;
                if (target < board.get_board_size()) {
                    if (!board.get_board().get(target).get_isOccupied()) {
                        if (board.get_board().get(target) instanceof Snake) {
                            if (board.get_butthole(target).get_isOccupied()) { // if true then butt**** of snake is occupied then player needs to go back to start
                                board.back_to_start(player);
                            } else {
                                board.move(player, board.get_board().get(target).get_destination());
                            }
                        } else if (board.get_board().get(target) instanceof Ladder) { // if ladder. "Butthole" looks at destination if it is not occupied
                            if (!board.get_butthole(target).get_isOccupied()) {
                                board.move(player, board.get_board().get(target).get_destination());
                            } else {
                                board.move(player, target); // if destination of board is occupied then the player stays at the bottom of the ladder
                            }
                        } else { // must be a regular Square
                            board.move(player, target);
                        }
                        // TODO: implement variation if a player goes over the LastSquare
                    }
                    // TODO: implement variation if a player would go on an occupied Square then it must go back to the start
                }
            }
        }
    }
}