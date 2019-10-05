import java.util.Random;
// create one Die object in GameLogic.  Die die = new Die()
// Use RollDie method when Player rolls the die. die.rollDie()
private final class Die {
    private Random rand = new Random();

    int rollDie(){
        return rand.nextInt(5) + 1; // nextInt(x) will pick a random int from 0 to x.
    }
}

// This class can be used now. look at comments line 6 and 7 in GameLogic