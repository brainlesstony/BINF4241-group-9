public class Snake extends Square {
    protected Snake(int position, int destination_snake) {
        super(position);
        this.set_isSnake(true);
        int destination = destination_snake;
    }
}
