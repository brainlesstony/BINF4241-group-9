import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameLogicTest {

// A few methods have already been tested in the BoardTest

//    Tested in BoardTest --> BoardTest.game_notOverTest()
//    @Test
//    public void GameRunningTest(){
//
//    }

//    Tested in BoardTest --> BoardTest.game_overTest()
//    @Test
//    public void land_on_LastSquare_EndTest(){
//
//    }

    /**
     * Checking whether a regular move is possible
     * @throws AssertionError if player lands on another field than indicated
     */
    @Test
    public void regular_moveTest(){
        Board board = new Board();
        board.setBoard_size(17);
        board.make_board();
        Player victor = new Player("Victor");
        board.move(victor,0); //Setting Player Victor on FirstSquare
        int target = 5;
        //GameLogic
        if (target < board.get_board_size()) {
            if (!board.get_board().get(target).get_isOccupied()) {
                board.move(victor, 5);
            }
        }

        Assertions.assertEquals(" <Victor> ", board.get_board().get(5).get_names());
    }

    /**
     * Checking whether it is possible to land on a Square of Type Snake
     * @throws AssertionError if a player cannot land on a Square of Type Snake
     */

    @Test
    public void land_on_snakeTest(){
    Board board = new Board();
    board.setBoard_size(18);
    board.make_board();
    board.set_snakes_and_ladders();
    //    Snake 1
    //    exchangeSnake(5, 3);
    Assertions.assertTrue(board.get_board().get(5).get_isSnake());
    Player peter = new Player("Peter");
    //GameLogic
    int target = 5;
    if (board.get_board().get(target) instanceof Snake) {
        board.move(peter, board.get_board().get(target).get_destination());
    }

    Assertions.assertEquals(" <Peter> ", board.get_board().get(3).get_names());
    }

    /**
     * Checking whether it is possible to land on a Square of Type Ladder
     * @throws AssertionError if a player cannot land on a Square of Type Ladder
     */

    @Test
    public void land_on_ladderTest(){
    Board board = new Board();
    board.setBoard_size(18);
    board.make_board();
    board.set_snakes_and_ladders();
        //Ladder 2
        //exchangeLadder(7, 10);
    Assertions.assertTrue(board.get_board().get(7).get_isLadder());
    Player samuel = new Player("Samuel");
    //GameLogic
    int target = 7;
    if (board.get_board().get(target) instanceof Ladder) {
        board.move(samuel, board.get_board().get(target).get_destination());
    }

    Assertions.assertEquals(" <Samuel> ", board.get_board().get(10).get_names());
    }

    /**
     * Checking that a player does not move when the target square is occupied.
     * @throws AssertionError if player moved onto the occupied square and away from his current field
     */

    @Test
    public void land_on_occupiedTest(){
    Board board = new Board();
    board.setBoard_size(18);
    board.make_board();
    Player peter = new Player("Peter");
    Player parker = new Player("Parker");
    board.move(parker,0); // Set Player "Parker" on FirstSquare
    board.move(peter, 3); // Set Player "Peter" on Square Nr. 3
    //GameLogic
    if (!board.get_board().get(3).get_isOccupied()) {
        board.move(parker, 3); // Try to move Player "Parker" on Square Nr. 3
    }

    Assertions.assertEquals(" <Parker> ", board.get_board().get(0).get_names());
    }

    /**
     * Checks whether a player moves onto the ladder if the destination is already occupied
     * @throws AssertionError if player moves onto the occupied field and away from his current field
     */

    @Test
    public void land_on_occupied_ladderTest(){
        Board board = new Board();
        board.setBoard_size(25);
        board.make_board();
        board.set_snakes_and_ladders();
        //Ladder 3
        //exchangeLadder(17,22);
        Assertions.assertTrue(board.get_board().get(17).get_isLadder());
        Player deborah = new Player("Deborah");
        Player samuel = new Player("Samuel");
        board.move(deborah,22); //Setting Player deborah on destination field of ladder
        int target = 17;
        //GameLogic
        if (board.get_board().get(target) instanceof Ladder) {
            if (!board.get_butthole(target).get_isOccupied()) {
                board.move(samuel, board.get_board().get(target).get_destination());
            } else {
                board.move(samuel, target);
            }
        }

        Assertions.assertEquals(" <Samuel> ", board.get_board().get(17).get_names());
    }

    /**
     * Checks whether a player moves onto the snake if the destination is already occupied should reset his position to FirstSquare
     * @throws AssertionError if player is not back on the FirstSquare
     */

    @Test
    public void land_on_occupied_snakeTest() {
        Board board = new Board();
        board.setBoard_size(14);
        board.make_board();
        board.set_snakes_and_ladders();
        // Snake 2
        //exchangeSnake(11, 6);
        Assertions.assertTrue(board.get_board().get(11).get_isSnake());
        Player christian = new Player("Christian");
        Player dario = new Player("Dario");
        int target = 11;
        board.move(christian, 6); // Set Player Christian onto destination of Snake Square
        //GameLogic
        if (board.get_board().get(target) instanceof Snake) {
            if (board.get_butthole(target).get_isOccupied()) {
                board.back_to_start(dario);
            } else {
                board.move(dario, board.get_board().get(target).get_destination());
            }
        }

        Assertions.assertEquals(" <Dario> ", board.get_board().get(0).get_names());

    }

    /**
     * Check whether the player can exceed the board
     * @throws AssertionError if player moves when he would exceed the board
     */

    @Test
    public void land_outsideTest(){
    Board board = new Board();
    board.setBoard_size(18);
    board.make_board();
    Player manfred = new Player("Manfred");
    board.move(manfred,17); // Set Player on Square Nr. 17
    int z = 4; // Number from dice
    int target = manfred.get_pos() + z;
    //GameLogic
    if (target < board.get_board_size()) {
        //do something
    }
    Assertions.assertEquals(" <Manfred> ", board.get_board().get(17).get_names());
    }
}
