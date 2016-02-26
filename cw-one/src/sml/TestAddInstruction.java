package sml;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

/**
 * Unit test class for AddInstruction.
 * Please refer to {@see TestBinaryInstruction} as that class holds the set up
 * of the mocking classes (Machine and Registers) and the arguments and return values
 * of methods in the execute() functionality (which is implemented in {@see BinaryInstruction}.
 *
 *
 * @author federico.bartolomei
 */
public class TestAddInstruction extends TestBinaryInstruction {

    // ???
    @Override
    protected Instruction init() {
        return null;
    }

    // -----------------------------------------------------------------------------------------------------------------

    // TODO test constructors with null, etc.

    @Test
    public void testConstructorShouldCallSuperClassAndPassItsArgs() {
        // TODO
    }

    @Test
    public void testConstructorShouldCallSuperClassAndPassLabelAndAdd() {
        // TODO
    }

    // void execute(Machine m) -----------------------------------------------------------------------------------------

    @Test
    public void testExecuteShouldSetRegisterWithRightValue() {
        // should set register 99 (with values of registers 100 and 123)
        new AddInstruction("f3", 0, 50, 10).execute(m);
        // the sum of values in registers 50 and 100
        int result = value1 + value2;
        // should be passed as second argument of setRegister()
        assertThat(args[1], is(result));
    }

    @Test
    public void testExecuteShouldSetRegisterAtRightIndexWithRightValue() {
        // should set register 99 (with values of registers 100 and 123)
        new AddInstruction("f3", 99, 100, 123).execute(m);
        // the sum of values in registers 100 and 123
        int result = value1 + value2;
        // should go to register 99
        assertThat(args[0], is(99));
        // and have the right value
        assertThat(args[1], is(result));
    }

    // String toString() -----------------------------------------------------------------------------------------------

    @Test
    public void testToStringShouldHaveCorrectLabelAndOpCode() {
        Instruction i = new AddInstruction("f0", 0, 0, 0);
        String s = i.toString();
        assertThat(s, containsString("f0: add"));
    }

    @Test
    public void testToStringShouldHaveCorrectOperatorsAndResult() {
        Instruction i = new AddInstruction("f0", 0, 0, 0);
        String s = i.toString();
        assertThat(s, containsString("0 + 0 to 0"));
    }

    @Test
    public void testToStringShouldHaveCorrectLabelOpcodeOperatorsAndResult() {
        Instruction i = new AddInstruction("f0", 0, 0, 0);
        String s = i.toString();
        assertThat(s, containsString("f0: add 0 + 0 to 0"));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
