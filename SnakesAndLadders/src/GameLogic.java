import java.util.Arrays;
import java.util.Scanner;

public class GameLogic {

    //static void moveFwd(int z);
      //  board[] = board[]
    //static void square();
        //gets location of player

    public static void main(String[] args) {


        // BOARD
        System.out.println("Let's start the game by first deciding on the board size!");
        System.out.println("What would you like the board size to be?");

        Scanner scanner_board = new Scanner(System.in);
        int board_size = scanner_board.nextInt();
        //int [] board = new int[board_size]; // board size begrenzung ? min ? max ?
        List<Square> board_liste = new ArrayList<Square>(); // Liste aller squares generieren
        //Square[] Squares = new Square[board_size];
        for( int i = 1; i <= board_size; i++){
            //board[i-1] = ; // square object noch anfügen
                            // wo sind snakes und ladders?
            board_liste.add(new Square(i+1));
        }
        System.out.println(Arrays.toString(board));

        // SNAKES AND LADDERS
        // wie machemer d begrenzig? wür sinn mache
        // functions sind unne definiert




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


        /*  redundant?
        for (int i = 0; i <= player_count-1; i++){
            thePlayer[i] = player_names[i];
        System.out.println("This will be the order in which the players will take turns");
        System.out.println(Arrays.toString(player_names));
        */


        // PLAY, ROLLING, MOVING
        //init all players on square1
        //print out state of game at the start
        Die die = new Die();
        int z = die.rollDie();
        //currently_playing = players.remove();
        //currently_playing.moveAndLand(z)
        //check if anything special
        //Board gives back new position
        //Board prints out current state of the game
        //currently_playing.square(); If position is last square end the game else continue
        //players.add(currently_playing);
        //Board prints out final state of the game
        //Loop

        }
        public Snake setSquareToSnake(Square square, int destination) {
            Snake new_snake = new Snake(destination);
            return new_snake;
        }

        public Square setSquareToLadder(Square square, int destination){
            square = new Ladder(destination);
            return square;
        }
    }


