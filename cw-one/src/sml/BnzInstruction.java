package sml;

/**
 * This class implements the "bnz" Instruction:
 * if the value of the register selected at construction time is not zero
 * or the statement label is unknown, the PC is not set and the instruction will be ignored;
 * if the value of the register selected is zero and the statement can be found within the Machine
 * labels, the PC is updated to execute that instruction next.
 *
 * @author federico.bartolomei
 */
public class BnzInstruction extends Instruction {
    private String statement;
    private int register;

    public BnzInstruction(String label, int register, String statement) {
        super(label, "bnz");
        this.register = register;
        this.statement = statement;
    }

    public boolean isValid(Machine m) {
        return m.getLabels().indexOf(statement) != -1;
    }

    @Override
    public void execute(Machine m) {
        int value = m.getRegisters().getRegister(register);
        int index = m.getLabels().indexOf(statement);
        if(value != 0 && index != -1) {
            m.setPc(index);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " register " + register + " to " + statement;
    }
}
