package sml;
import java.util.function.IntBinaryOperator;

/**
 * Enum class representing a binary operation;
 * holds the String opcode which should be called from the Machine,
 * its associated symbol and its associated Integer binary operation
 * which implementing classes of {@see BinaryInstruction} should use
 * for the execute(Machine) method.
 *
 * reference: http://stackoverflow.com/a/28922263
 *
 * @author federico.bartolomei
 */
enum BinaryOp implements IntBinaryOperator {

    PLUS("add", '+', (op1, op2) -> op1 + op2),
    SUB("sub", '-', (op1, op2) -> op1 - op2),
    MUL("mul", '*', (op1, op2) -> op1 * op2),
    DIV("div", '/', (op1, op2) -> op1 / op2);

    private final String opcode;
    private final char symbol;
    private final IntBinaryOperator op;

    BinaryOp(final String label, final char symbol, final IntBinaryOperator op) {
        this.opcode = label;
        this.symbol = symbol;
        this.op = op;
    }

    public String getOpcode() {
        return opcode;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public int applyAsInt(final int op1, final int op2) {
        return op.applyAsInt(op1, op2);
    }

}
