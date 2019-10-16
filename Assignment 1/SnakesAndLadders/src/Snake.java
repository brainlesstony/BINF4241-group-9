public class Snake extends Square {
    private int destination;

    protected Snake(int position, int destination_snake) {
        super(position);
        this.set_isSnake(true);
        this.destination = destination_snake;
        this.set_type(get_destination() + "]" + "<-" + "[");
    }

    public int get_destination() {
        return this.destination;
    }
    @Override
    public String toString(){
        return "[" + this.get_type() + Integer.toString(get_position()) + "]" + get_names();
    }
}

