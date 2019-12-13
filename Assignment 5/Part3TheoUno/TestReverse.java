import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestReverse{

    /**
    * this test checks if the sequence of the player actually reverses
     * if reversed than first player == lastplayer
    */
    @Test
    public void test_reverse(){
        Card reverse = new Reverse();
        Main main = new Main();
        main.init();
        Player first = main.getplayerlist()[0];
        reverse.reverseQueue(main.getplayerlist());
        assertEquals("reverseQueue method does not work D:", first, main.getplayerlist()[-1])
    }
}