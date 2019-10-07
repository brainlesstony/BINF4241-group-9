public class FirstSquare extends Square {
    private String players_string = "";
    public FirstSquare(int position){
        super(position);
        this.set_isFirst(true);
        this.type = "FirstSquare";
    }

    @Override
    public String toString(){
        return "[Position: " + Integer.toString(get_position()) + ", Destination: " + Integer.toString(get_destination()) +  ", Type: " + get_type() + ", Player: " + get_names() + "]";
    }
}