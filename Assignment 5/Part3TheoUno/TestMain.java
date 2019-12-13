import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestMain(){

    /**
     * Test initialization of the playerlist
     */
    @Test
    pubic void test_init_playerlist(){
        Main main = new Main();
        main.init();
        assertTrue("too less or too much players", 2 <= main.getplayerlist().size() <= 10)
    }

    /**
     * Test that after initialization the discardpile length is 1
     */
    @Test
    public void test_init_drawpile(){
        Main main = new Main();
        main.init();
        assertTrue("Discard Pile after init not length 1", main.getdiscardpile().size() == 1)
    }

    /**
    * Test that after init the activeplayer must be the first player in the playerlist
    */
    @Test
    public void test_init_activeplayer(){
        Main main = new Main();
        main.init();
        assertEquals("After init, the wrong player is activeplayer", main.getactiveplayer(), main.getplayerlist()[0])
    }

    /**
     * Test if after this method the next player is active.
     */
    @Test
    public void test_nextactiveplayer(){
        Main main = new Main();
        main.init();
        Player playersave = main.getactiveplayer();
        main.nextactiveplayer();
        assertTrue("next active player method does not work D:", playerlist.get(playersave) + 1 == playerlist.get(main.getactiveplayer()))
    }


}