package sml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Unit test class for OutInstruction.
 * Please refer to {@see MachineMocks} for details about the the mocking classes (Machine and Registers)
 * and the arguments and return values of methods in the execute() functionality.
 *
 * @author federico.bartolomei
 */
public class TestOutInstruction extends MachineMocks {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        super.setupMocks();
        System.setOut(new PrintStream(out));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    // void execute(Machine m) -----------------------------------------------------------------------------------------

    @Test
    public void testExecuteShouldGetTheRightRegister() {
        new OutInstruction("f0", 10).execute(randomMachine);
        // the parameter passed in Registers.getRegister(int i)
        int i = op1;
        // should be 10, the number of the register in the test instruction
        assertThat(i, is(10));
    }

    @Test
    public void testExecuteZeroShouldPrintlnTheCorrectValue() {
        // the content of the register is 0 with this mock
        new OutInstruction("f1", 0).execute(zeroMachine);
        // the result should be "0" and newline
        String result = value1.toString() + '\n';
        assertEquals(result, out.toString());
    }

    @Test
    public void testExecuteRandomShouldPrintlnTheCorrectValue() {
        // the content of the register is a random value with this mock
        new OutInstruction("f2", 0).execute(randomMachine);
        // the random value plus newline
        String result = value1.toString() + '\n';
        // should have been printed out
        assertEquals(result, out.toString());
    }

    // String toString() -----------------------------------------------------------------------------------------------

    @Test
    public void testToStringShouldHaveCorrectLabelAndOpCode() {
        Instruction i = new OutInstruction("f0", 0);
        String s = i.toString();
        assertThat(s, containsString("f0: out"));
    }

    @Test
    public void testToStringShouldHaveCorrectOperatorsAndResult() {
        Instruction i = new OutInstruction("f0", 10);
        String s = i.toString();
        assertThat(s, containsString("println register 10"));
    }

    @Test
    public void testToStringShouldHaveCorrectLabelOpcodeOperatorsAndResult() {
        Instruction i = new OutInstruction("f0", 20);
        String s = i.toString();
        assertThat(s, containsString("f0: out println register 20"));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
