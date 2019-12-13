import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestPlayer{

    /**
     * This test checks if a player draws the right amount of cards
      */
    @Test
    public void test_draw(){
        Player player1 = new Player("Tony");
        DrawPile drawpile = new DrawPile();
        drawpile.createdeck();
        int amount= player1.gethanddeck().size();
        player1.draw(1, drawpile);
        assertTrue("Player can not draw right amount of cards", amount + 3 == player1.gethanddeck().size())
    }

    /**
     *
     */
    @Test
    public void test_put_card(){
        Player player1 = new Player("Tony");
        int handdecksize = player1.gethanddeck().size();
        DiscardPile dp = new DiscardPile();
        Card acard = new Card(CardColor.green, 8);
        player1.put_card(acard, discardpile);
        assertTrue("put card not working", handdecksize - 1 == player1.gethanddeck().size())
    }
}