package Washing_Machine;
enum Program{Double_Rinse, Intense, Quick, Spin, None}

public class Washing_Machine {
    private Program my_program;

    public Washing_Machine(){
        this.my_program = Program.None;
    }

    private Program get_program(){
        return my_program;
    }

    void set_Program(Program program_input){
        if (program_input == Program.Double_Rinse) {
            this.my_program = Program.Double_Rinse;
        }else if (program_input == Program.Intense) {
            this.my_program = Program.Intense;
        }else if (program_input == Program.Quick) {
            this.my_program = Program.Quick;
        }else if (program_input == Program.Spin){
            this.my_program = Program.Spin;
        }
    }
}
