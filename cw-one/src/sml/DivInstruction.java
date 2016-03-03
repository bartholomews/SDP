package sml;

/**
 * This class implements the "div" Instruction: as it is a binary operation
 * it extends abstract class {@see BinaryInstruction} to inherit its toString()
 * and functionality of execute(Machine).
 *
 * @author federico.bartolomei
 */

public class DivInstruction extends BinaryInstruction {

    /**
     * Constructor takes a label which will be passed to superclass
     * {@see Instruction} together with the opcode retrieved from
     * {@see BinaryOp}; the indexes of the Registers result, op1 and op2
     * are stored as fields in {@see BinaryInstruction} to be used
     * to perform the operation.
     *
     * @param label the label of the operation
     * @param result the index of the Register that will hold the result
     * @param op1 the index of the Register that hold the first operand
     * @param op2 the index of the Register that hold the second operand
     */
    public DivInstruction(String label, int result, int op1, int op2) {
        super(label, BinaryOp.DIV.getOpcode(), result, op1, op2);
    }

    /**
     * Execute an addition operation on Machine m;
     * the values of the operands are retrieved by the superclass {@see BinaryInstruction}
     * using the indexes of the Registers given as arguments in the constructor,
     * the operation performed is found in {@see BinaryOp} as matched against the value
     * passed to the superclass at construction time.
     *
     * @param m the Machine on which the Instruction is to be performed
     */
    @Override
    public void execute(Machine m) {
        super.execute(m);
    }

}
