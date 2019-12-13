import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

class TestDiscardPile{

    /**
     *  This function tests if the discard pile actually shuffles.
     *  The posibility is very small that a card stays at the same place after shuffling.
     *  So we can test that
     */
    @Test
    public void Test_shuffle(){
        DiscardPile discardpile = new DiscardPile();
        Card acard = discardpile.card_list[0];
        discardpile.shuffle();
        Card bcard = discardpile.card_list[0];
        assertFalse("something went wrong shuffling discardpile", acard == bcard);
    }
}
