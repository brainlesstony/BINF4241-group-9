enum ColorSquare {W,B}
public class Square {
    private ColorSquare aColor;
    private Piece aPiece;
    private String aPosition;
    private Boolean aOccupied;


    public Square (ColorSquare nColor, Piece nPiece, String nPosition, Boolean nOccupied){
        aColor = nColor;
        aPiece = nPiece;
        aPosition = nPosition;
        aOccupied = nOccupied;


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


}