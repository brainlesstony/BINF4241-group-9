enum Type{K, Q, T, N, P, B}
enum Color{W, B}
public class Piece {
    private Color color;
    private Type type;
    private boolean moved;

    public Piece(Color color, Type type, boolean has_moved){
        this.type = type;
        this.color = color;
        this.moved = has_moved;
    }
    public Type getType(){ return this.type;}
    public Color getColor(){ return this.color;}
    public boolean get_has_moved(){return this.moved;}


    @Override
    public String toString(){
        return "["+this.color.toString()+"."+this.type.toString()+"]";
    }
}