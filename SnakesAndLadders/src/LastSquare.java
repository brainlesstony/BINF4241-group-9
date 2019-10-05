public class LastSquare extends Square{
    public check_gameOver(){
        if (this.isOccupied){
            System.out.println("Game over!!!" + this.get_player() + " wins!")
                    return 0; // end programm
        }
    }


}
