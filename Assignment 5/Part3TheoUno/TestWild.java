import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestWild{


    /**
     * Test checks if setnextcolor methods works
     */
    public void test_setnextColor(){
        Main main = new Main();
        Card wild = new Wild();
        wild.setnextaskedcolor(CardColor.red, color);
        assertTrue("setnextColor failed", CardColor.red, main.getnextaskedcolor());
    }


}