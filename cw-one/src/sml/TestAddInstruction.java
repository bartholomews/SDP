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
 * Test class for AddInstruction.
 * Here it is not tested particular cases that are not of AddInstruction's concern
 * (for instance number of registers allowed), just mocks
 * the classes used in its methods (Machine and underlying Registers)
 * to verify that the correct arguments are passed.
 * TODO make superclass junit parameterised BinaryInstruction and UnaryInstruction to avoid code repetition
 *
 * @author federico.bartolomei
 */
public class TestAddInstruction {
    // a Machine mock class with mock Registers
    Machine m;
    // the argument of first call Registers.getRegister(int i)
    int op1;
    // the argument of second call Registers.getRegister(int i)
    int op2;
    // the value returned from first call Registers.getRegister(int i)
    int value1;
    // the value returned from second call Registers.getRegister(int i)
    int value2;
    // the arguments of method call Registers.setRegister(int i, int v)
    Object[] args;

    @Before
    @SuppressWarnings("unchecked")
    public void setup() {

        // to generate random registers values
        Random random = new Random();

        // mock Registers class
        Registers r = mock(Registers.class);

        /* when getRegister is called, assign invocation arguments
          to value1 and value2 for first and second call respectively;
          a successive call would throw an exception as this instruction
          should call getRegister twice to get the content of two registers only;
          the value of the registers returned (a random int)
          is assigned to vars value1 and value2 for first and second call respectively,
          to be checked against the setRegister method which should add them up;
        */
        when(r.getRegister(anyInt()))

                .thenAnswer(invocation1 -> {
                    value1 = random.nextInt();
                    op1 = (Integer) invocation1.getArguments()[0];
                    return value1;
                })

                .thenAnswer(invocation2 -> {
                    value2 = random.nextInt();
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                })

                // compiler warns for unchecked generics array creation for varargs parameter here;
                .thenThrow(IllegalStateException.class);

        /* when Registers.setRegister(int i, int v) is called,
         invocation arguments are assigned to variable args
         to be checked against the operation that should have been performed;
         note: doAnswer is necessary here because setRegister() returns void;
        */
        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(r).setRegister(anyInt(), anyInt());

        // mock Machine class returning the mock Registers
        m = mock(Machine.class);
        when(m.getRegisters()).thenReturn(r);
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
    public void testVarsShouldBeZeroBeforeRunningExecute() {
        assertThat(op1, is(0));
        assertThat(op2, is(0));
        assertThat(value1, is(0));
        assertThat(value2, is(0));
    }

    @Test
    public void testExecuteShouldSetRegisterWithTwoArgs(){
        // before running the test args should not have been initialised
        assertThat(args, is(nullValue()));
        new AddInstruction("f0", 0, 0, 0).execute(m);
        // after execute() is called, Registers.setRegister(i, v)
        // should have been called with two args: the index of the register and its new value;
        assertThat(args.length, is(2));
    }

    @Test
    public void testExecuteWithDifferentRegsShouldGetTheRegistersAtRightIndexes() {
        // should get registers at index 10 and 20
        new AddInstruction("1", 0, 10, 20).execute(m);
        // two calls to Registers.getRegister(i) should get the two registers, in any order
        assertThat(op1, isOneOf(10, 20));
        assertThat(op2, isOneOf(10, 20));
        assertNotEquals(op1, op2);
    }

    @Test
    public void testExecuteWithSameRegsShouldGetTheRegistersAtRightIndexes() {
        // should get registers at index 10 and 20
        new AddInstruction("1", 0, 10, 10).execute(m);
        assertThat(op1, is(10));
        assertEquals(op1, op2);
    }

    @Test
    public void testExecuteShouldSetRegisterAtRightIndex() {
        // should set register 10
        Instruction test = new AddInstruction("f2", 10, 0, 1);
        test.execute(m);
        assertThat(args[0], is(10));
    }

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
