enum Color {White,Black}
enum Row {One,Two,Three,Four,Five,Six,Seven,Eight}
enum Column {A,B,C,D,E,F,G,H}
public class Square {
    private Color aColor;
    private Row aRow;
    private Column aColumn;

    public Square (Color nColor,Row nRow,Column nColumn){
        aColor = nColor;
        aRow = nRow;
        aColumn = nColumn;


    }
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
