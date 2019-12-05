import org.junit.Test;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;

public class PlayerListTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void ui_player_countTestEmpty(){
        PlayerList playlist = new PlayerList();
        Player fabio = new Player("Fabio");
        playlist.setAddPlayer(fabio);
        Assertions.assertFalse(playlist.get_player_list().isEmpty());
    }
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
    @Test
    public void ui_player_countTest1Player(){
        PlayerList playlist = new PlayerList();
        Player fabio = new Player("Fabio");
        playlist.setAddPlayer(fabio);

    }
}

