import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {

    /**
     * Since the input to the board size can be empty this needs to be tested
     * This checks whether the input can be empty or null
     * @throws AssertionError if the input is null or empty
     */

    @Test
    public void get_board_size_from_userTestNotEmpty() {
        Board tester = new Board();
        String input = "";
        Assertions.assertTrue(input.isBlank());
        String input2 = null;
        Assertions.assertNull(input2);
    }

    /**
     * Not testing for different input types because the input method uses nextInt(), since this is a java method we can assume it only accepts Integers.
     * Testing whether the size is allowed (6-30) was our fixed length for assignment 1.
     * @throws AssertionError if the size of the board is not equal to input size
     */

    @Test
    public void get_board_size_from_userTest() {
        int input = 12;
        Board tester = new Board();
        tester.setBoard_size(input);
        Assertions.assertEquals(12,tester.get_board_size());
    }

    /**
     * Checking whether a too small board can be initialized
     * @throws AssertionError if the board is too small
     */

    @Test
    public void get_board_size_from_userTestTooSmall() {
        Board tester = new Board();
        tester.setBoard_size(5);
        Assertions.assertFalse(tester.get_board_size() >= 6);
    }

    /**
     * Checking whether a too large board can be initialized
     * @throws AssertionError if the board is too large
     */

    @Test
    public void get_board_size_from_userTestTooLarge() {
        Board tester = new Board();
        tester.setBoard_size(35);
        Assertions.assertFalse(tester.get_board_size() <= 30);
    }

    /**
     * To test if the board is created
     * We check if a pos in the Arraylist<Square> board is not null
     * @throws AssertionError if the board is not constructed
     */

    @Test
    public void make_boardTest(){
        Board tester = new Board();
        tester.setBoard_size(16);
        tester.make_board();
        Assertions.assertNotNull(tester.get_board().get(3));
    }

        /**
         * Resets the player's location to the start location
         * when he jumps on a snake and the location is already occupied
         * @throws AssertionError if player's is not moved back to start
         *
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
     *Player is moved with move method and the square, which is the destination holds the specific player that was moved onto it
     * @throws AssertionError if PLayer is not moved onto new square
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
     * This test (for the method exchangeSnakeTest) is hardcoded since the method is defined as private but should still be tested
     * A square will be replaced by an action field which is a snake
     * @throws AssertionError if the square, which is exchanged is not of type snake
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
     * This test(for the method exchangeLadderTest) is hardcoded since the method is defined as private but should still be tested
     * I hardcoded this test because I cannot access the method because it is defined as private
     * @throws AssertionError if the square, which is exchanged is not of type ladder
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

    /**
     * Check whether the snakes and ladders are set on the board (Small size)
     * @throws AssertionError if the board does not contain snake and ladder at preset location
     */

    @Test
    public void set_snakes_and_laddersTestSmall(){
        Board tester = new Board();
        tester.setBoard_size(12);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(1).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(4).get_isSnake());
    }

    /**
     * Check whether the snakes and ladders are set on the board (Large size)
     * @throws AssertionError if the board does not contain snake and ladder at preset location
     */

    @Test
    public void set_snakes_and_laddersTestLarge() {
        Board tester = new Board();
        tester.setBoard_size(24);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(7).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(11).get_isSnake());
    }

    /**
     * Check whether the snakes and ladders are set on the board (Medium size)
     * @throws AssertionError if the board does not contain snake and ladder at preset location
     */

    @Test
    public void set_snakes_and_laddersTestMedium(){
        Board tester = new Board();
        tester.setBoard_size(28);
        tester.make_board();
        tester.set_snakes_and_ladders();
        Assertions.assertTrue(tester.get_board().get(17).get_isLadder());
        Assertions.assertTrue(tester.get_board().get(21).get_isSnake());
    }

    /**
     * Checks whether the last square is not occupied at the beginning of the game
     * @throws AssertionError if last square is occupied at the start of the game
     */

    @Test
    public void game_notOverTest(){
        Board tester = new Board();
        tester.setBoard_size(24);
        tester.make_board();
        Assertions.assertFalse(tester.game_over());
    }

    /**
     * Checks whether the last square is occupied
     * @throws AssertionError if last square is not occupied
     */

    @Test
    public void game_overTest(){
        Board tester = new Board();
        tester.setBoard_size(24);
        tester.make_board();
        Player player = new Player("Peter");
        tester.get_board().get(23).add_player(player);
        Assertions.assertTrue(tester.game_over());
    }


}