public class Main {
    public static void main(String[] args){
        Smartphone smartphone = new Smartphone();

        while (true){
            run();
        }
    }

    public void run(){
        print_menu(); // should print available machines as stated in the assignment
        receive_next_action(); // user should choose which machine and action
        print_user_action(); // prints the user action or a fail notification
        fake_flush();
    }



}
