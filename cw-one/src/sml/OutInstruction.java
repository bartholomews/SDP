package sml;

/**
 * This class implements the "out" Instruction.
 *
 * @author federico.bartolomei
 */
public class OutInstruction extends Instruction {
    private int register;

    public OutInstruction(String label, int register) {
        super(label, "out");
        this.register = register;
    }

    @Override
    public void execute(Machine m) {
        System.out.println(m.getRegisters().getRegister(register));
    }

    @Override
    public String toString() {
        return super.toString() + " println register " + register;
    }
}
