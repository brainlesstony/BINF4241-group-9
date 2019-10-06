import org.w3c.dom.ls.LSOutput;

import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class GameLogic {

    public static void main(String[] args) {


        // BOARD
        System.out.println("Let's start the game by first deciding on the board size!");
        System.out.println("What would you like the board size to be?");
        System.out.println("The board size cannot be smaller then 6 or larger than 30");
        Scanner scanner_board = new Scanner(System.in);
        int board_size = scanner_board.nextInt();
        if (board_size < 6 || board_size > 30){
            System.exit(0);
        }

        Square [] Squares= InitializeSquares(board_size);


        // INIT SNAKES & LADDERS

        if(board_size > 24) {
            //Ladder 1
            exchangeLadder(Squares[1], 4, Squares);

            // Snake 1
            exchangeSnake(Squares[4], 3, Squares );

            //Ladder 2
            exchangeLadder(Squares[6], 10, Squares);

            // Snake 2
            exchangeSnake(Squares[10], 6, Squares);

            //Ladder 3
            exchangeLadder(Squares[20],12, Squares);

            // Snake 3
            exchangeSnake(Squares[13], 22, Squares);
        }
        else if (board_size > 12) {
            //Ladder 1
            exchangeLadder(Squares[1], 4, Squares );

            // Snake 1
            exchangeSnake(Squares[4], 3, Squares);

            //Ladder 2
            exchangeLadder(Squares[6], 10, Squares);

            // Snake 2
            exchangeSnake(Squares[10], 6, Squares);
        }
        else{
            //Ladder 1
            exchangeLadder(Squares[1], 4, Squares);

            // Snake 1
            exchangeSnake(Squares[4], 3, Squares);
        }

        // DEFINITION FIRST & LAST SQUARE
        FirstSquare firstsquare = new FirstSquare(1);
        Squares[0] = firstsquare;

        LastSquare lastsquare = new LastSquare(board_size);
        Squares[Squares.length-1] = lastsquare;


        // PLAYER INPUT
        System.out.println("How many players are playing?");
        Scanner scanner_name_num = new Scanner(System.in);
        int player_count = scanner_name_num.nextInt();

        if (player_count < 2 || player_count > 4){
            System.out.println("Sorry, this game can only be played by 2-4 players");
            System.exit(0);
        }

        System.out.println("What are the " + player_count + " players name? ");
        List<Player> player_list = new ArrayList<Player>();
        Scanner player_name = new Scanner(System.in); // creates Scanner
        for (int i = 1; i <= player_count; i++){
            System.out.print("Player " + i + ": ");
            String read_names = player_name.nextLine(); // reads User Input
            Player new_player = new Player(read_names);
            player_list.add(new_player);
            Squares[0].add_player(new_player);
        }

        // PLAY, ROLLING, MOVING
        System.out.println(Arrays.toString(Squares));
        Die die = new Die();
        while(!Squares[Squares.length - 1].get_isOccupied()){ // While last square is not occupied, the game will go on
            for (Player i : player_list){
                int z = die.rollDie();
                int target = i.get_onSquare() + z;
                if(target-1 >= board_size){

                    // todo Special Case When going over the end
                } else if(!Squares[target - 1].get_isOccupied()){
                    if(!Squares[target - 1].get_type().equals("Square")){
                        if(Squares[target - 1].get_type().equals("Snake")){
                            Square ziel = Squares[target-1];
                            if(Squares[ziel.get_destination()-1].get_isOccupied()){
                                //Squares[i.get_onSquare()-1].set_isOccupied(false);
                                //Squares[i.get_onSquare()-1].set_playername(null);
                                Squares[i.get_onSquare()-1].remove_player(i);

                                i.set_position(1);

                                //Squares[0].set_isOccupied(true);
                                //Squares[0].set_playername(i.get_name());
                                Squares[0].add_player(i);
                            }
                            else{
                                //Squares[i.get_onSquare()-1].set_isOccupied(false);
                                //Squares[i.get_onSquare()-1].set_playername(null);
                                Squares[i.get_onSquare()-1].remove_player(i);


                                i.set_position(ziel.get_destination());

                                //Squares[ziel.get_destination()-1].set_isOccupied(true);
                                //Squares[ziel.get_destination()-1].set_playername(i.get_name());
                                Squares[ziel.get_destination()-1].add_player(i);
                            }
                        }
                        else if(Squares[target - 1].get_type().equals("Ladder")){
                            Square ziel = Squares[target -1];
                            if(Squares[ziel.get_destination()-1].get_isOccupied()){
                                //Squares[i.get_onSquare()-1].set_isOccupied(false);
                                //Squares[i.get_onSquare()-1].set_playername(null);
                                Squares[i.get_onSquare()-1].remove_player(i);


                                i.set_position(ziel.get_position());

                                //Squares[ziel.get_position()-1].set_isOccupied(true);
                                //Squares[ziel.get_position()-1].set_playername(i.get_name());
                                Squares[ziel.get_position()-1].add_player(i);

                            }
                            else{
                                //Squares[i.get_onSquare()-1].set_isOccupied(false);
                                //Squares[i.get_onSquare()-1].set_playername(null);
                                Squares[i.get_onSquare()-1].remove_player(i);


                                i.set_position(ziel.get_destination());

                                //Squares[ziel.get_destination()-1].set_isOccupied(true);
                                //Squares[ziel.get_destination()-1].set_playername(i.get_name());
                                Squares[ziel.get_destination()-1].add_player(i);
                            }

                        }
                        else if(Squares[target-1].get_isLast()){
                            normal_position_update(Squares,target,i);
                            System.out.println(i.get_name() + " has won!");
                            System.exit(0);
                        }
                    }
                    else{
                        normal_position_update(Squares,target,i);
                    }
                }
                //Game Update
                //System.out.println(Arrays.toString(Squares));

            }
        }
    }

    // SNAKES AND LADDERS
    private static Square[] InitializeSquares(int board_size) {
        Square[] Squares= new Square[board_size];
        for(int i = 1; i <= board_size ; i++)
        {
            Squares[i-1] = new Square(i);
        }
        return Squares;
    }

    // EXCHANGE STATEMENTS
    private static void exchangeSnake(Square square,int destination,  Square [] Squares) {
        Snake new_snake = new Snake(square.get_position(), destination);
        Squares[square.get_position() - 1] = new_snake;
    }

    private static void exchangeLadder(Square square,int destination,  Square [] Squares) {
        Ladder new_ladder = new Ladder(square.get_position(), destination);
        Squares[square.get_position() - 1] = new_ladder;
    }

    /**
     *
     * @param Squares
     * @param target
     * @param i
     */
    private static void normal_position_update(Square [] Squares,int target, Player i){
        Square ziel = Squares[target -1];
        Squares[i.get_onSquare()-1].remove_player(i);

        i.set_position(ziel.get_position());
        Squares[ziel.get_position()-1].add_player(i);
        System.out.println(Arrays.toString(Squares));
    }

}

