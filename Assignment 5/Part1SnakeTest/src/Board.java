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
        String in = scanner_board.nextLine();
        if (in.equals("")){
            System.out.println("Board must satisfy the requirements!");
            System.exit(0);
        }
        for (char letter : in.toCharArray()) {
            if (!Character.isDigit(letter)) {
                System.out.println("Board size can only be an integer value");
                System.exit(0);
            }
        }
        int board_size_from_user = Integer.parseInt(in);
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
            exchangeLadder(1, 14);

            // Snake 1
            exchangeSnake(15, 3);

            //Ladder 2
            exchangeLadder(12, 22);

            // Snake 2
            exchangeSnake(23, 6);

            //Ladder 3
            exchangeLadder(17,22);

            // Snake 3
            exchangeSnake(21, 3);
        }
        else if (board_size > 12) {
            //Ladder 1
            exchangeLadder(2, 4);

            // Snake 1
            exchangeSnake(5, 3);

            //Ladder 2
            exchangeLadder(7, 10);

            // Snake 2
            exchangeSnake(11, 6);
        }
        else{
            //Ladder 1
            exchangeLadder(1, 3);

            // Snake 1
            exchangeSnake(4, 2);
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
    public void print(Player player, int die){
        System.out.println(board);
        System.out.print(player.get_name() + " rolls " + die + ": ");
    }
    public boolean game_over(){
        return get_board().get(get_board_size()-1).get_isOccupied();
    }
    public String check_square(int x){
        return get_board().get(x).get_type();
    }
    public void move(Player player, int moves){
        get_board().get(player.get_pos()).remove_player(player);
        player.set_position(moves);
        get_board().get(player.get_pos()).add_player(player);
    }
    public Square get_butthole(int target){
        return get_board().get(get_board().get(target).get_destination());
    }
    public void back_to_start(Player player){
        get_board().get(player.get_pos()).remove_player(player); // remove player from origin square
        player.set_position(0); // set player to pos 0
        get_board().get(0).add_player(player);
    }

    void setBoard_size(int i) {
        this.board_size = i;
    }
}
