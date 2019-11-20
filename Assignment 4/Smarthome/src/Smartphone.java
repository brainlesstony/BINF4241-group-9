import Interfaces.Command;
public class Smartphone {
    public Command[] listofcommands;

    public Smartphone() {
        Command noCommand = new NoCommand();
        for (int i = 0; i < 8; i++) {
            listofcommands[i] = noCommand;
}
    }



    public void setCommand(int i, Command c) {
        listofcommands[i] = c; }

    public void pressButton(int buttonNum) {
        listofcommands[buttonNum].execute(); }


}
