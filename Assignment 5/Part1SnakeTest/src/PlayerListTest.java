import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PlayerListTest {


    /**
     *Testing to make sure input cannot be empty
     * @throws AssertionError if the input for the player_list can be empty
     */

    @Test
    public void ui_player_countTestEmpty(){
        PlayerList playlist = new PlayerList();
        String input = "";
        Assertions.assertTrue(input.isBlank());
        Assertions.assertTrue(playlist.get_player_list().isEmpty());
    }

    /**
     * Testing whether a player can be added on the board
     * @throws AssertionError if a player cannot be added to the board (FirstSquare)
     */

    @Test
    public void add_player_on_boardTest(){
        Board board = new Board();
        Player new_player = new Player("Johnny");
        PlayerList list = new PlayerList();
        board.setBoard_size(16);
        board.make_board();
        list.get_player_list().add(new_player);
        board.get_board().get(0).add_player(new_player);
        Assertions.assertEquals(" <Johnny> ",board.get_board().get(0).get_names());
    }

    /**
     * Testing whether a normal player_list can be created
     * @throws AssertionError if the player_list cannot be created with a normal amount of players
     */

    @Test
    public void ui_player_countTest3PlayersExpected(){
        PlayerList playlist = new PlayerList();
        Player fabio = new Player("Fabio");
        Player tony = new Player("Tony");
        Player stef = new Player("Stef");
        playlist.setAddPlayer(fabio);
        playlist.setAddPlayer(tony);
        playlist.setAddPlayer(stef);
        Assertions.assertEquals(3,playlist.get_player_list().size());
    }

    /**
     * Testing whether a player_list can be created with only one player or too many
     * @throws AssertionError if the player_list can be created with one or more than 4 players
     */
    @Test
    public void ui_player_countTestWrongAmountOfPlayers(){
        PlayerList playlist = new PlayerList();
        Player fabio = new Player("Fabio");
        playlist.setAddPlayer(fabio);
        Assertions.assertNotEquals(2, playlist.get_player_list().size());
        Assertions.assertNotEquals(3, playlist.get_player_list().size());
        Assertions.assertNotEquals(4, playlist.get_player_list().size());
        Player peter = new Player("Peter");
        playlist.setAddPlayer(peter);
        Player marco = new Player("Marco");
        playlist.setAddPlayer(marco);
        Player matthias = new Player("Matthias");
        playlist.setAddPlayer(matthias);
        Player tony = new Player("Tony");
        playlist.setAddPlayer(tony);
        Assertions.assertNotEquals(2, playlist.get_player_list().size());
        Assertions.assertNotEquals(3, playlist.get_player_list().size());
        Assertions.assertNotEquals(4, playlist.get_player_list().size());
    }
}

