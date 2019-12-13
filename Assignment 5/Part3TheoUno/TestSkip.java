import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestSkip(){

    /**
     * this test checks if a player has been skipped.
     *
     */
    @Test
    public void test_skip(){
        Card skip = new Skip(CardColor.blue);
        Main main = new Main();
        int player1pos = main.getplayerlist().get(main.getactiveplayer());
        skip.skipnextplayer(main.getplayerlist());
        assertTrue("skip does not work D:", player1pos + 2 == main.getplayerlist().get(main.getactiveplayer());
    }

    /**
     * this test checks if it skips to the right direction when a reveres card have been played.
     *
     */
    @Test
    public void test_skip(){
        Card skip = new Skip(CardColor.blue);
        Card reverese = new Reverse(CardColor.blue);
        Main main = new Main();
        reverese.revereseQueue(main.getplayerlist());
        int player1pos = main.getplayerlist().get(main.getactiveplayer());
        skip.skipnextplayer(main.getplayerlist());
        assertTrue("skip does not work after reverse D:", player1pos - 2 == main.getplayerlist().get(main.getactiveplayer());
        }



}