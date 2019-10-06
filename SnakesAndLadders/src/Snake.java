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
        return "[Position: " + Integer.toString(get_position()) + ", Destination: " + Integer.toString(get_destination()) +  ", Type: " + get_type() + ", Player: " + get_names() + "]";
    }
}
