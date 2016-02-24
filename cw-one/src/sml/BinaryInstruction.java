package sml;

/**
 * Abstract class for Binary operations, to sit in between Instruction and the implementing
 * subclasses of Instruction that use two operands (e.g. 'add', 'sub', 'mul', 'div')
 * to avoid code repetition (e.g. toString() method, retrieving the two registers);
 * implementing subclasses's constructor should take four parameters:
 * the String label of the operation (to be passed to the superclass Instruction)
 * two registers whose values are the two operands of the binary operation (int op1 and op2)
 * a register to store the result in (int result).
 *
 * @author federico.bartolomei
 */
public abstract class BinaryInstruction extends Instruction {
    private int op1;
    private int op2;
    private int result;

    /**
     * Constructor to set the label and opcode,
     * to be passed from the implementing subclass to the superclass Instruction;
     * The operation should be a valid Binary Instruction set up in {@see BinaryOp}.
     *
     * @param label the label of the operation
     * @param op    the operation to be performed (particular of the implementing subclass)
     */
    public BinaryInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Indexes of registers to be used for the Instruction
     *
     * @param result the register which will store the final result
     * @param op1    the register holding the value of the first operand
     * @param op2    the register holding the value of the second operand
     */
    public BinaryInstruction(String label, String opcode, int result, int op1, int op2) {
        this(label, opcode);
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Gets the protected opcode passed by the constructor to the superclass Instruction at build time,
     * which should be a valid binary operation ("add", "sub", "div" etc.)
     * and matches it against {@see BinaryOp} enum class which holds the opcode/symbol/operation;
     * if a valid binary operation (present in BinaryOp list) is passed to the constructor,
     * its corresponding enum is retrieved. The enum is holding the String value
     * of the operation, its associated symbol to be used in toString() method, and its
     * binary operation functionality to be called in execute(Machine).
     *
     * @return a {@see BinaryOp} holding the String for that operation, the associated symbol and the operation itself;
     * @throws IllegalArgumentException if the String op does not find a match with a BinaryOp value;
     */
    public BinaryOp getOpcode() {
        for(BinaryOp binaryOp : BinaryOp.values()) {
            if(binaryOp.getOpcode().equals(opcode)) {
                return binaryOp;
            }
        }
        throw new IllegalArgumentException("Opcode does not have a match with BinaryOp operations");
    }

    /**
     * Execute the operation associated with the binary operation value in {@see BinaryOp}
     * Implementing subclasses need only to pass the Machine object on which to execute
     * the operation; the opcode String is retrieved at construction time and the operation
     * to be performed in BinaryOp.
     *
     * @param m the Machine to be executed with the BinaryInstruction of type passed at construction time;
     */
    @Override
    public void execute(Machine m) {
        BinaryOp op = getOpcode();
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);
        m.getRegisters().setRegister(result, op.applyAsInt(value1, value2));
    }

    /** 
     * toString() method shared by all the Binary Instructions; 
     * the particular symbol of the subclass operation is retrieved from the opcode String in the constructor, 
     * which is matched against {@see BinaryOp} enum class holding the associated symbol;
     * @return a String formed as "label: opcode" (inherited from superclass Instruction), 
     *         the indexes of the Registers holding the operands, the symbol of the operation
     *         to be performed, and the index of the Register which will store the result; 
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " " + getOpcode().getSymbol() + " " + op2 + " to " + result;
    }
}
