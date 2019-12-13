import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestCard{

    /**
     * This test controlls if a card has return the right color as it was initialized.
     */
    @Test
    public void test_getColor(){
        Card acard = new Card(CardColor.blue, 6);
        assertEqual("get color method not working", CardColor.blue, acard.getColor());
    }

    /**
     * This test checks if a card has the right rank as it was initialized.
     */
    @Test
    public void test_getRank(){
        Card acard = new Card(CardColor.green, 8);
        assertTrue("get rank method not working",8 == acard.getRank());
    }


}