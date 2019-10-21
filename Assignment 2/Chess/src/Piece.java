enum Type{K, Q, T, N, P, B}
enum Color{W, B}
public class Piece {
    private Color color;
    private Type type;
    private boolean moved;

    public Piece(Color color, Type type,Boolean has_moved){
        this.type = type;
        this.color = color;
        this.moved = has_moved;
    }
    public Type getType(){ return this.type;}
    public Color getColor(){ return this.color;}
    public Boolean get_Moved(){return this.moved;}

    @Override
    public String toString(){
        return "["+this.color.toString()+"."+this.type.toString()+"]";
    }
}