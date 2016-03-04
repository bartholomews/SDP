package sml;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Unit test class for LinInstruction.
 * Please refer to {@see MachineMocks} for details about the the mocking classes (Machine and Registers)
 * and the arguments and return values of methods in the execute() functionality.
 *
 * @author federico.bartolomei
 */
public class TestLinInstruction extends MachineMocks {

    @Before
    public void setup() {
        super.setupMocks();
    }

    // void execute(Machine m) -----------------------------------------------------------------------------------------

    @Test
    public void testExecuteShouldSetTheRightRegister() {
        new LinInstruction("f0", 10, 2).execute(randomMachine);
        // first arg of method call Registers.setRegister(int i, int v)
        int registerToSet = (Integer) args[0];
        assertThat(registerToSet, is(10));
    }

    @Test
    public void testExecuteShouldSetTheRightValue() {
        new LinInstruction("f0", 10, 2).execute(randomMachine);
        // second arg of method call Registers.setRegister(int i, int v)
        int valueToSet = (Integer) args[1];
        assertThat(valueToSet, is(2));
    }

    @Test
    public void testExecuteShouldSetTheRightRegisterWithTheRightValue() {
        new LinInstruction("f1", 20, 30).execute(zeroMachine);
        // first arg of method call Registers.setRegister(int i, int v)
        int registerToSet = (Integer) args[0];
        // second arg of method call Registers.setRegister(int i, int v)
        int valueToSet = (Integer) args[1];
        assertThat(registerToSet, is(20));
        assertThat(valueToSet, is(30));
    }

    // String toString() -----------------------------------------------------------------------------------------------

    @Test
    public void testToStringShouldHaveCorrectLabelAndOpCode() {
        Instruction i = new LinInstruction("f0", 0, 0);
        String s = i.toString();
        assertThat(s, containsString("f0: lin"));
    }

    @Test
    public void testToStringShouldHaveCorrectOperatorsAndResult() {
        Instruction i = new OutInstruction("f0", 10);
        String s = i.toString();
        assertThat(s, containsString("register 10"));
    }

    @Test
    public void testToStringShouldHaveCorrectLabelOpcodeOperatorsAndResult() {
        Instruction i = new LinInstruction("f0", 20, 10);
        String s = i.toString();
        assertEquals(s, "f0: lin register 20 value is 10");
    }

    // -----------------------------------------------------------------------------------------------------------------

}
