package sml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Abstract class for unit testing of binary operations (add, subtract, multiply etc.);
 * All the subclasses of Instruction that use two operands (that is, perform an operation
 * on two registers and store the result)
 */

public abstract class TestBinaryInstruction extends TestInstruction {
    /**
     * A subclass of BinaryInstruction can test common functionality extending this test class
     * and passing its instance in the init() method to override.
     */
    private BinaryInstruction instruction;

    /**
     * The BinaryInstruction subclass which run these tests.
     */
    private Class instructionToLoad;
    /**
     * The arguments of the constructor of classToLoad;
     */
    private Class[] instructionArgs;

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

    protected abstract BinaryInstruction init();

    // Set up the mocking classes --------------------------------------------------------------------------------------

    @Before
    @SuppressWarnings("unchecked")
    public void setup() {

        /**
         * Get the implementation of BinaryInstruction running these tests.
         */
        instruction = init();

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

    @After
    public void tearDown() {
        instruction = null;
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
        instruction.execute(m);
        // after execute() is called, Registers.setRegister(i, v)
        // should have been called with two args: the index of the register and its new value;
        assertThat(args.length, is(2));
    }

}
