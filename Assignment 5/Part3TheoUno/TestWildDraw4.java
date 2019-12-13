import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestWildDraw4{

    /**
     * Test if giveCardmethod gives 4 cards
     */
    @Test
    public void test_giveCard(){
        Card wildd4 = new WildDraw4();
        Main main = new Main();
        Player player1 = new Player("Tony"); // this player has 0 cards
        wildd4.giveCard(player1, main.getdrawpile());
        assertTrue("give method did not gave 4 cards", player1.gethanddeck().size() == 4)

    }

}