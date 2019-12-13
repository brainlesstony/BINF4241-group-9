import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestDraw2(){

    /**
     *  Actually this the method should give the next player two cards but we
     * just want to test if it gives two cards to a random player.
     */
    @Test
    public void test_giveCard(){
        Player player1 = new Player("Tony");
        Pile handdeckp1 = player1.gethanddeck();
        Card draw2 = new Draw2(CardColor.green);
        draw2.giveCard(player1);
        assertTrue("draw 2 does not work", handdeckp1.size() - 2 == player1.gethanddeck().size())
    }


}