public class FirstSquare extends Square {
    private Player [] players;
    private String players_string;
    public FirstSquare(int position){
        super(position);
        this.set_isFirst(true);
        for(Player i : players) players_string += i.get_name() + ", ";
    }

    @Override
    public String toString(){
        return "[Position: " + Integer.toString(this.get_position()) + ", Destination: " + Integer.toString(this.get_destination()) +  ", Type: " + this.get_type() + ", Player: " + players_string + "]";
    }
}