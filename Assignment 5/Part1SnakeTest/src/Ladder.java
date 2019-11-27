public class Ladder extends Square {
    private int destination;

    protected Ladder(int postition, int destination_Ladder) {
        super(postition);
        this.set_isLadder(true);
        this.destination = destination_Ladder;
        this.set_type("->" + "[" + get_destination() + "]");
    }

    public int get_destination(){
        return this.destination;
    }

}
