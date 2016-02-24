package sml;

/**
 * This class implements the "add" Instruction: as it is a binary operation
 * it extends abstract class {@see BinaryInstruction} to inherit its toString()
 * and functionality of execute(Machine).
 *
 * @author federico.bartolomei
 */

public class AddInstruction extends BinaryInstruction {

    /**
     * Constructor will pass label and opcode to BinaryInstruction all the way up to Instruction.
     *
     * @param label the label of the operation
     * @param op the operation to be performed ("add", see overloaded constructor)
     */
    public AddInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Constructor that should be called from the Translator class;
     * the indexes of the Registers result, op1 and op2 are stored
     * as fields in {@see BinaryInstruction} via setValues().
     *
     * @param label the label of the operation
     * @param result the index of the Register that will hold the result
     * @param op1 the index of the Register that hold the first operand
     * @param op2 the index of the Register that hold the second operand
     */
    public AddInstruction(String label, int result, int op1, int op2) {
        this(label, BinaryOp.ADD.getOpcode());
        super.setValues(result, op1, op2);
    }

    /**
     * Execute an addition operation on Machine m;
     * the values of the operands are retrieved by the superclass {@see BinaryInstruction}
     * using the indexes of the Registers given as arguments in the constructor,
     * the operation performed is found in {@see BinaryOp} as matched against the String op
     * which is the argument of the constructor
     *
     * @param m the Machine on which the Instruction is to be performed
     */
    @Override
    public void execute(Machine m) {
        super.execute(m);
    }

}
