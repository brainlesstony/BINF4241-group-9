enum Type{K, Q, T, N, P, B}
enum Color{W, B}
public class Piece {
    private Color color;
    private Type type;

    public Piece(Color color, Type type){
        this.type = type;
        this.color = color;
    }

    public Type getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return "["+this.color.toString()+"."+this.type.toString()+"]";
    }
}