import Interfaces.Command;
public class Smartphone {
    Command[] onSlots;

    public Smartphone() {
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onSlots[i] = noCommand;
}
    }
    public void setOnCommand(int i, Command c) {
        onSlots[i] = c; }

    public void pressOnButton(int buttonNum) {
        onSlots[buttonNum].execute(); }


}
