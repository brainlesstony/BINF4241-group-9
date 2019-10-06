import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
        //for( int i = 1; i <= board_size; i++){
            //board[i-1] = ; // square object noch anfügen
            // wo sind snakes und ladders?
        //board_liste.add(new Square(i+1));
        //ArrayList<Square> board_liste = new ArrayList<Square>(); // Liste aller squares generieren
        //for (int i = 1; i < board_size; i ++)
            //Square[] Squares = new Square[];
        Square [] Squares= InitializeSquares(board_size);


        //snakes and ladders positioning

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



        System.out.println(Arrays.toString(Squares));

        // PLAYER INPUT
        System.out.println("How many players are playing?");
        Scanner scanner_name_num = new Scanner(System.in);
        int player_count = scanner_name_num.nextInt();

        if (player_count < 2 || player_count > 4){
            System.out.println("Sorry, this game can only be played by 2-4 players");
            System.exit(0);
        }

        System.out.println("What are the" + player_count + "players name? ");
        List<Player> player_list = new ArrayList<Player>();
        Scanner player_name = new Scanner(System.in); // creates Scanner
        for (int i = 1; i <= player_count; i++){
            System.out.print("Player " + i + " :");
            String read_names = player_name.nextLine(); // reads User Input
            player_list.add(new Player(read_names));

        }

        Die die = new Die();

        while(Squares[-1].get_isOccupied() == false){
            for (Player i : player_list){
                int z = die.rollDie();
                int target = i.get_onSquare()  +z;
                if(Squares[target-1].get_isOccupied() == false){
                    if(Squares[target-1].get_type() != "Square"){
                        if(Squares[target-1].get_type() == "Snake"){
                            Square ziel = Squares[target-1];
                            if(Squares[ziel.get_destination()-1].get_isOccupied()){
                                Squares[i.get_onSquare()-1].set_isOccupied(false);
                                Squares[i.get_onSquare()-1].set_playername(null);

                                i.set_position(1);

                                Squares[0].set_isOccupied(true);
                                Squares[0].set_playername(i.get_name());
                            }
                            else{
                                Squares[i.get_onSquare()-1].set_isOccupied(false);
                                Squares[i.get_onSquare()-1].set_playername(null);

                                i.set_position(ziel.get_destination());

                                Squares[ziel.get_destination()-1].set_isOccupied(true);
                                Squares[ziel.get_destination()-1].set_playername(i.get_name());
                            }
                        }
                        else if(Squares[target-1].get_type() == "Ladder"){
                            Square ziel = Squares[target -1];
                            if(Squares[ziel.get_destination()-1].get_isOccupied()){
                                Squares[i.get_onSquare()-1].set_isOccupied(false);
                                Squares[i.get_onSquare()-1].set_playername(null);

                                i.set_position(ziel.get_position());

                                Squares[ziel.get_position()-1].set_isOccupied(true);
                                Squares[ziel.get_position()-1].set_playername(i.get_name());
                            }
                            else{
                                Squares[i.get_onSquare()-1].set_isOccupied(false);
                                Squares[i.get_onSquare()-1].set_playername(null);

                                i.set_position(ziel.get_destination());

                                Squares[ziel.get_destination()-1].set_isOccupied(true);
                                Squares[ziel.get_destination()-1].set_playername(i.get_name());
                            }

                        }
                        else if(Squares[target-1].get_isLast()){
                            System.out.println(i.get_name() + " has won!");
                        }
                    }
                    else{
                        Square ziel = Squares[target -1];
                        Squares[i.get_onSquare()-1].set_isOccupied(false);
                        Squares[i.get_onSquare()-1].set_playername(null);

                        i.set_position(ziel.get_position());

                        Squares[ziel.get_position()-1].set_isOccupied(true);
                        Squares[ziel.get_position()-1].set_playername(i.get_name());
                    }
                }
                //Game Update
                System.out.println(Arrays.toString(Squares));

            }
        }

    }
        // PLAY, ROLLING, MOVING
        //init all players on square1

        /*
        //print out state of game at the start
        for(int k = 0; k < board_size; k++){
            System.out.println(board_liste.get(k));
        }
        Die die = new Die();
        int z = die.rollDie();
        currently_playing = player_list.remove(0);

        if (board_liste[z + Player.currently_playing.destination].isoccupied()){
            Player.onsquare = Player.onsquare;
        }
        else {
                Player.currently_playing.moveAndLand(z);
        }


        //check if anything special
        //Board gives back new position
        //Board prints out current state of the game
        //currently_playing.square(); If position is last square end the game else continue
        player_liste = player_list.add(currently_playing);
        //Board prints out final state of the game
        //Loop

    }
    */
    // SNAKES AND LADDERS
    private static Square[] InitializeSquares(int board_size) {
        Square[] Squares= new Square[board_size];
        for(int i = 1; i <= board_size ; i++)
        {
            Squares[i-1] = new Square(i);
        }
        return Squares;
    }

    private static void exchangeSnake(Square square,int destination,  Square [] Squares) {
        Snake new_snake = new Snake(square.get_position(), destination);
        Squares[square.get_position() - 1] = new_snake;
    }

    private static void exchangeLadder(Square square,int destination,  Square [] Squares) {
        Ladder new_ladder = new Ladder(square.get_position(), destination);
        Squares[square.get_position() - 1] = new_ladder;
    }
}

