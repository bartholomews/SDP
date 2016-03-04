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
 * on two registers and store the result). Here are implemented the Mock classes to be used
 * by the various subclasses tests.
 */

public abstract class TestBinaryInstruction extends TestInstruction {
    /**
     * A subclass of BinaryInstruction can test common functionality extending this test class
     * and passing its instance in the init() method to override.
     */
    private BinaryInstruction instruction;

    // a Machine mock class with underlying randomRegs (Registers mock class with random regs values)
    Machine randomMachine;
    // a Machine mock class with underlying zeroRegs (Registers mock class with regs values always zero)
    Machine zeroMachine;
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

        // mock Registers class which always returns values 0s
        Registers zeroRegs = mock(Registers.class);

        // mock Registers class which returns random values
        Registers randomRegs = mock(Registers.class);

        /* when getRegister is called, assign invocation arguments
          to op1 and op2 for first and second call respectively;
          a successive call would throw an exception as this instruction
          should call getRegister twice to get the content of two registers only;
          the value of the registers returned (a random int for randomRegs, zero for zeroRegs)
          is assigned to vars value1 and value2 for first and second call respectively.
        */
        when(randomRegs.getRegister(anyInt()))
                .thenAnswer(invocation1 -> {
                    value1 = random.nextInt();
                    op1 = (Integer) invocation1.getArguments()[0];
                    return value1;
                })
                .thenAnswer(invocation2 -> {
                    // value2 should not have result 0, otherwise tests for division by zero
                    // would be unexpected; testing division by zero should be done with
                    // the zeroMachine(zeroRegs) mock.
                    do {
                        value2 = random.nextInt();
                    } while(value2 == 0);
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                })
                // compiler warns for unchecked generics array creation for varargs parameter here;
                .thenThrow(IllegalStateException.class);

        when(zeroRegs.getRegister(anyInt()))
                .thenAnswer(invocation1 -> {
                    value1 = 0;
                    op1 = (Integer) invocation1.getArguments()[0];
                    return value1;
                })
                .thenAnswer(invocation2 -> {
                    value2 = 0;
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                })
                .thenThrow(IllegalStateException.class);

        /* when Registers.setRegister(int i, int v) is called,
         invocation arguments are assigned to variable args
         to be checked against the operation that should have been performed;
         note: doAnswer is necessary here because setRegister() returns void;
        */
        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(randomRegs).setRegister(anyInt(), anyInt());

        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(zeroRegs).setRegister(anyInt(), anyInt());

        randomMachine = mock(Machine.class);
        when(randomMachine.getRegisters()).thenReturn(randomRegs);

        zeroMachine = mock(Machine.class);
        when(zeroMachine.getRegisters()).thenReturn(zeroRegs);
    }

    @After
    public void tearDown() {
        instruction = null;
    }

    // void execute(Machine) -----------------------------------------------------------------------------------------

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
        instruction.execute(randomMachine);
        // after execute() is called, Registers.setRegister(i, v)
        // should have been called with two args: the index of the register and its new value;
        assertThat(args.length, is(2));
    }

}
