enum ColorSquare {W,B}
public class Square {
    private ColorSquare aColor;
    private Piece aPiece;
    private String aPosition;


    public Square (ColorSquare nColor, Piece nPiece, String nPosition){
        aColor = nColor;
        aPiece = nPiece;
        aPosition = nPosition;


    }

    @Override
    public String toString(){
        if (aPiece == null){
            return "[   ]";
        }
        else{
            return aPiece.toString();
        }
    }

    public Piece get_Piece(){
        return aPiece;
    }
    public ColorSquare get_Color(){return aColor;}
    public String get_Position(){ return aPosition;}
    public Boolean get_is_empty(){return aPiece == null;}
    public void set_Piece(Piece piece){this.aPiece = piece; }



    /*protected String type;
    private String position;

    Squares(String position) {
        this.type = "";
        this.position = position;

    }

    public void set_Square_white() {
        this.type = "white";
    }
    public void set_Square_black() {
        this.type = "white";
    }
    public void set_Position(){
        this.position = ""; // not quite sure how to set string position via board without making board public
    }*/
}