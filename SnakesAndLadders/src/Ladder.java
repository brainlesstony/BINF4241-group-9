public class Ladder extends Square {
    private int destination;

    protected Ladder(int postition, int destination_Ladder) {
        super(postition);
        this.set_isLadder(true);
        this.set_type("Ladder");
        this.destination = destination_Ladder;
    }

    public int get_destination(){
        return this.destination;
    }
    @Override
    public String toString(){
        return "[Position: " + Integer.toString(this.get_position()) + ", Destination: " + Integer.toString(this.get_destination()) +  ", Type: " + this.get_type() + ", Player: " + this.get_playername() + "]";
    }
}
