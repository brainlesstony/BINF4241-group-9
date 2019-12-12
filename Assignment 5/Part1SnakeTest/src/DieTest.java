import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class DieTest {


    /**
     * Instead of testing the dice on the normal distribution. The java library is already tested enough by java.
     * Therefore I test each outcome of the dice and if the player moves correctly for each dice role.
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_1Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,1);
        Assertions.assertTrue(tester.get_board().get(1).get_isOccupied());
    }

    /**
     * Testing if a dice rolls 2, and the player moves 2
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_2Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,2);
        Assertions.assertTrue(tester.get_board().get(2).get_isOccupied());
    }

    /**
     * Testing if a dice rolls 3, and the player moves 3
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_3Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,3);
        Assertions.assertTrue(tester.get_board().get(3).get_isOccupied());
    }

    /**
     * Testing if a dice rolls 4, and the player moves 4
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_4Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,4);
        Assertions.assertTrue(tester.get_board().get(4).get_isOccupied());
    }

    /**
     * Testing if a dice rolls 5, and the player moves 5
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_5Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,5);
        Assertions.assertTrue(tester.get_board().get(5).get_isOccupied());
    }

    /**
     * Testing if a dice rolls 6, and the player moves 6
     * @throws AssertionError if the player does move more or less than he should
     */

    @Test
    public void Die_6Test(){
        Board tester = new Board();
        Player player = new Player("Peter");
        tester.setBoard_size(16);
        tester.make_board();
        tester.get_board().get(0).add_player(player);
        tester.move(player,6);
        Assertions.assertTrue(tester.get_board().get(6).get_isOccupied());
    }
}
