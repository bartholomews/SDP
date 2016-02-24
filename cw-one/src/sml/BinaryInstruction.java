package sml;

/**
 * Abstract class for Binary operations, to sit in between Instruction and the implementing
 * subclasses of Instruction that use two operands (that is add, sub, mul etc.)
 * to avoid code repetition (toString(), retrieving the two registers, etc.);
 * implementing subclasses takes four parameters:
 * the String label of the operation (to be passed to the superclass Instruction)
 * two registers whose values are the two operands of the binary operation (int op1 and op2)
 * a register to store the result in (int result);
 *
 * @author federico.bartolomei
 */
public abstract class BinaryInstruction extends Instruction {
    private int op1;
    private int op2;
    private int result;

    /**
     * Constructor to set the label and opcode,
     * to be passed from the implementing subclass to the superclass Instruction
     *
     * @param label the label of the operation
     * @param op the operation to be performed (particular of the implementing subclass)
     */
    public BinaryInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Indexes of registers to be used for the Instruction
     *
     * @param result the register which will store the final result
     * @param op1 the register holding the value of the first operand
     * @param op2 the register holding the value of the second operand
     */
    public void setValues(int result, int op1, int op2) {
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * The value held in register op1 of Machine selected as parameter
     *
     * @param m the Machine holding the registers
     * @return the value held in register op1 of Machine m
     */
    public int getValue1(Machine m) {
        return m.getRegisters().getRegister(op1);
    }

    /**
     * The value held in register op2 of the Machine selected as parameter
     *
     * @param m the Machine holding the registers
     * @return the value held in register op2 of Machine m
     */
    public int getValue2(Machine m) {
        return m.getRegisters().getRegister(op2);
    }

    /**
     *
     * @return
     */
    public int getResult() {
        return result;
    }

}
