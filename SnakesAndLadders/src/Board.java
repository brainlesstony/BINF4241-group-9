import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private int board_size;
    private List<Square> board;

    public Board(){
        this.board_size = 0;
        this.board = new ArrayList<Square>();
    }
    public void board_message(){
        System.out.println("Let's start the game by first deciding on the board size!");
        System.out.println("What would you like the board size to be?");
        System.out.println("The board size cannot be smaller then 6 or larger than 30");
    }
    public void make_board(){
        board.add(0, new FirstSquare(0));
        for (int i = 1; i <= get_board_size() - 2 ; i++){
            board.add(i, new Square(i));
        }
        board.add(get_board_size() - 1, new LastSquare(get_board_size() - 1));

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
    public void set_snakes_and_ladders(){
        if(board_size > 24) {
            //Ladder 1
            exchangeLadder(1, 4);

            // Snake 1
            exchangeSnake(4, 3);

            //Ladder 2
            exchangeLadder(6, 10);

            // Snake 2
            exchangeSnake(10, 6);

            //Ladder 3
            exchangeLadder(20,12);

            // Snake 3
            exchangeSnake(13, 22);
        }
        else if (board_size > 12) {
            //Ladder 1
            exchangeLadder(1, 4);

            // Snake 1
            exchangeSnake(4, 3);

            //Ladder 2
            exchangeLadder(6, 10);

            // Snake 2
            exchangeSnake(10, 6);
        }
        else{
            //Ladder 1
            exchangeLadder(1, 4);

            // Snake 1
            exchangeSnake(4, 3);
        }
    }
    // EXCHANGE METHODS
    private void exchangeSnake(int which_square, int destination) {
        Snake snake = new Snake(which_square, destination);
        get_board().set(which_square, snake);
    }
    private void exchangeLadder(int which_square, int destination) {
        Ladder ladder = new Ladder(which_square, destination);
        get_board().set(which_square, ladder);
    }
    public void print(){
        System.out.println(board);
    }
    public boolean game_over(){
        return get_board().get(get_board_size()-1).get_isLast();
    }
    public String check_square(int x){
        return get_board().get(x).get_type();
    }
}
