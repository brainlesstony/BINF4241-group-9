enum Type{K, Q, T, N, P, B}
enum Color{W, B}
public class Piece {
    private Color color;
    private Type type;

    public Piece(Color color, Type type){
        this.type = type;
        this.color = color;
    }
    //TODO These methods are mainly for rules
    //TODO method has_reached_end() only implement for pawn
    //TODO methods start_location(), current_location(), new_location()
    public Type getType(){ return this.type;}
    public Color getColor(){ return this.color;}

    @Override
    public String toString(){
        return "["+this.color.toString()+"."+this.type.toString()+"]";
    }
}