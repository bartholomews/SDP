package sml;

/**
 *
 */
public enum BinaryOp {

    ADD("add", '+'),
    SUB("sub", '-'),
    MUL("mul", '*'),
    DIV("div", '/');

    private char symbol;
    private String opcode;

    BinaryOp(String label, char symbol) {
        this.opcode = label;
        this.symbol = symbol;
    }

    public String getOpcode() {
        return opcode;
    }

    public char getSymbol() {
        return symbol;
    }
}
