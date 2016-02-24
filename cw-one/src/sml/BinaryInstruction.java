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
    private BinaryOp op;

    /**
     * Constructor to set the label and opcode,
     * to be passed from the implementing subclass to the superclass Instruction
     *
     * @param label the label of the operation
     * @param op    the operation to be performed (particular of the implementing subclass)
     */
    public BinaryInstruction(String label, String op) {
        super(label, op);
        this.op = getBinaryOpByOpcode(op);
    }

    /**
     * Indexes of registers to be used for the Instruction
     *
     * @param result the register which will store the final result
     * @param op1    the register holding the value of the first operand
     * @param op2    the register holding the value of the second operand
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
     * Gets a String which should be a valid binary operation ("add", "sub", "div" etc.)
     * and matches it against {@see BinaryOp} enum class which holds tuples operation/symbol;
     * if a valid binary operation (present in BinaryOp list) is passed to the constructor,
     * its corresponding enum is passed to the field op. The enum is holding the String value
     * of the operation and the associated symbol to be used in toString() method.
     *
     * @param op the String op passed to the constructor, representing a valid binary operation;
     * @return a {@see BinaryOp} holding the String for that operation an the associated symbol;
     * @throws IllegalArgumentException if the String op does not find a match with a BinaryOp value;
     */
    public static BinaryOp getOpValueByOpcode(String op) { 
        for (BinaryOp b : BinaryOp.values()) { 
            if (b.getOpcode().equals(op)) { 
                return b; 
            } 
        }
        throw new IllegalArgumentException("Opcode does not have a match with BinaryOp operations"); 
    }

    /**
     * @return
     */
    public int getResult() {
        return result;
    }

    /** 
     * toString() method shared by all the Binary Instructions; 
     * the particular symbol of the subclass operation is retrieved from the label String in the constructor, 
     * which is matched against {@see BinaryOp} enum class holding tuples of binary operation/symbol; 
     * @return a String formed as "label: opcode:" (inherited from superclass Instruction), 
     *         the indexes of the Registers holding the operands, the symbol of the operation
     *         to be performed, and the index of the Register which will store the result; 
     */
    @Override
    public String toString() { 
        return super.toString() + " " + op1 + " " + op.getSymbol() + " " + op2 + " to " + result; 
    }

}
