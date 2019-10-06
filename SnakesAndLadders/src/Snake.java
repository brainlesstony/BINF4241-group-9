public class Snake extends Square {
    private int destination;
    protected Snake(int position, int destination_snake) {
        super(position);
        this.set_isSnake(true);
        this.set_type("Snake");
        this.destination = destination_snake;
    }

    public int get_destination(){
        return this.destination;
    }
    @Override
    public String toString(){
        return "[Position: " + Integer.toString(this.get_position()) + ", Destination: " + Integer.toString(this.get_destination()) +  ", Type: " + this.get_type() + ", Player: " + this.get_playername() + "]";
    }
}
