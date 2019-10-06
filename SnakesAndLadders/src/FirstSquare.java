public class FirstSquare extends Square {
    //private Player [] players;
    private String players_string = "";
    public FirstSquare(int position){
        super(position);
        set_isFirst(true);
    }

    @Override
    public String toString(){
        return "[Position: " + Integer.toString(get_position()) + ", Destination: " + Integer.toString(get_destination()) +  ", Type: " + get_type() + ", Player: " + get_names() + "]";
    }
}