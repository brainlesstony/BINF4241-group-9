import org.junit.Test;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class BoardTest {

    public void shouldTakeUserInput(String user_input) {
        InputStream in = new ByteArrayInputStream(user_input.getBytes());
        System.setIn(in);
    }
//    public void shouldTakeUserInput(Integer user_input) {
//        InputStream in = new ByteArrayInputStream(user_input.getBytes());
//        System.setIn(in);
//    }

//    @Test
//    public void get_board_size_from_userTest(){
//        StringInput
//        shouldTakeUserInput();
//    }
    
    
    
    
        /**
         * Resets the player's location when he jumps on a snake and the location is already occupied
         * Made a new function set Boardsize for testing purposes
         * @return true
         */
        
    @Test
    public void backToStartTest(){
        //setup
        Player peter = new Player("Peter");
        Board tester = new Board();
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(4).add_player(peter);
        tester.back_to_start(peter);
        Assertions.assertEquals(" <Peter> ",tester.get_board().get(0).get_names());
    }

    /**
     *
     */
    @Test
    public void moveTest(){
        Player pan = new Player("Pan");
        Board tester = new Board();
        tester.setBoard_size(16);
        tester.make_board();
        tester.move(pan,5);
        Assertions.assertEquals(" <Pan> ",tester.get_board().get(5).get_names());
    }

    /**
     * I hardcoded this test because I cannot access the method because it is defined as private
     * @return true if there is now a snake instead of a normal square
     */

    @Test
    public void exchangeSnakeTest(){
        Board tester = new Board();
        tester.setBoard_size(16);
        tester.make_board();
        Snake snake = new Snake(2, 4);
        tester.get_board().set(2, snake);
        Assertions.assertTrue(tester.get_board().get(2).get_isSnake());
    }

    /**
     * I hardcoded this test because I cannot access the method because it is defined as private
     * @return true if there is now a ladder instead of a normal square
     */

    @Test
    public void exchangeLadderTest(){
        Board tester = new Board();
        tester.setBoard_size(16);
        tester.make_board();
        Ladder ladder = new Ladder(2, 4);
        tester.get_board().set(2, ladder);
        Assertions.assertTrue(tester.get_board().get(2).get_isLadder());

    }

    @Test
    public void set_snakes_and_laddersTestSmall(){
        Board tester = new Board();
        tester.setBoard_size(12);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(1).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(4).get_isSnake());

    }
    @Test
    public void set_snakes_and_laddersTestLarge() {
        Board tester = new Board();
        tester.setBoard_size(24);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(7).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(11).get_isSnake());
    }
    @Test
    public void set_snakes_and_laddersTestMedium(){
        Board tester = new Board();
        tester.setBoard_size(28);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(17).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(21).get_isSnake());
    }


}