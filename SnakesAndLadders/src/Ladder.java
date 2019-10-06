public class Ladder extends Square {
    protected Ladder(int postition, int destination_Ladder) {
        super(postition);
        this.set_isLadder(true);
        int destination = destination_Ladder;
    }
}
