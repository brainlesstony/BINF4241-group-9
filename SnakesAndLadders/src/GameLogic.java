import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class GameLogic {

    public static void main(String[] args) {


        // BOARD
        System.out.println("Let's start the game by first deciding on the board size!");
        System.out.println("What would you like the board size to be?");
        System.out.println("The board size cannot be smaller then 6");
        Scanner scanner_board = new Scanner(System.in);
        int board_size = scanner_board.nextInt();
        if (board_size < 6){
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
        for(Square i: Squares){
            System.out.println(i.toString());

        }
        // PLAYER INPUT
        System.out.println("How many players are playing?");
        Scanner scanner_name_num = new Scanner(System.in);
        int player_count = scanner_name_num.nextInt();

        if (player_count < 2 || player_count > 4){
            System.out.println("Sorry, this game can only be played by 2-4 players");
            System.exit(0);
        }

        System.out.println("What are the players name?");
        String[] player_names = new String[player_count];
        int temp_count = player_count;

        while(temp_count > 0 ) {
            Scanner player_name = new Scanner(System.in);
            String read_names = player_name.nextLine();
            player_names[temp_count-1] = read_names;
            //Player [] thePlayers = new Player[player_count];
            //thePlayers[temp_count-1] = read_names;
            temp_count -= 1;
        }

            //player_names(list of Player names) to Class Player to init Players
            //Peter = new Player("Peter");
            //Marcus = new Player("Marcus");
            //player attribute current location
            //remove method to dequeue first person in queue
            //add method to enqueue playing person
            //method moveAndLand(z) communicate with square
            //Output: Players = list of Player objects

        // PLAY, ROLLING, MOVING
        //init all players on square1

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
    // SNAKES AND LADDERS

    public Snake setSquareToSnake(Square square, int destination) {
            Snake new_snake = new Snake(destination);
            return new_snake;
        }

        public Square setSquareToLadder(Square square, int destination){
            square = new Ladder(destination);
            return square;
        }
        private static Square[] InitializeSquares(int board_size) {
        Square[] Squares= new Square[board_size];
        for(int i = 0; i < board_size + 1; i++)
        {
            Squares[i] = new Square(i);
        }
        return Squares;
    }
    }

