import java.util.List;
import java.util.Scanner;

public class Board {
    private int board_size;
    private List<Square> board;

    private Board(){
        this.board_size = 0;
        this.board = null;
    }
    public void make_board(){
        board.set(0, new FirstSquare(0));
        board.set(get_board_size() - 1, new LastSquare(get_board_size() - 1));
        for (int i = 1; i <= get_board_size() - 2 ; i++){
            board.set(i, new Square(i));
        }
    } // creates the board
    public void get_board_size_from_user(){
        Scanner scanner_board = new Scanner(System.in);
        int board_size_from_user = scanner_board.nextInt();
        if (board_size_from_user < 6 || board_size_from_user > 30){
            System.out.println("Board must satisfy the requirements!");
            System.exit(0);
        }
        board_size = board_size_from_user;
    } // call this method first.
    public List<Square> get_board(){
        return board;
    }
    public int get_board_size(){
        return board_size;
    }
    public Snake set_snakes(){
        
    }
    public Ladder set_ladders(){

    }
    // EXCHANGE STATEMENTS
    private void exchangeSnake(int which_square, int destination) {
        Snake snake = new Snake(which_square, destination);
        get_board().set(which_square, snake);
    }

    private void exchangeLadder(int which_square, int destination) {
        Ladder ladder = new Ladder(which_square, destination);
        get_board().set(which_square, ladder);
}
