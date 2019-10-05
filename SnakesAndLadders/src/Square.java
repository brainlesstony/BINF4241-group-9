


public class Square {
    private boolean free = True; // is Square occupied?

    void changeState(){ // changing the status of the Square if its free or not
        if (free){
            free = False;
        }
        else {
            free = True;
        }
    }
}
