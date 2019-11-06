public class Scoreboard implements Observer{
    private int whiteScore;
    private int blackScore;

    public Scoreboard(){
        this.whiteScore=0;
        this.blackScore=0;
    }
    public void update(int white_score, int black_score){
        this.whiteScore = white_score;
        this.blackScore = black_score;
    }

    @Override
    public String toString(){
        return "Score White: "+whiteScore+", Score Black: "+blackScore;
    }
}
