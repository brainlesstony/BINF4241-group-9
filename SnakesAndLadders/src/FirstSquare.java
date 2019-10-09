public class FirstSquare extends Square {
    private String players_string = "";
    public FirstSquare(int position){
        super(position);
        this.set_isFirst(true);
    }
}