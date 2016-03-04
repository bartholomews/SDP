package sml;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * Abstract class for unit testing of binary operations (add, subtract, multiply etc.);
 * All the subclasses of Instruction that use two operands (that is, perform an operation
 * on two registers and store the result). The Mock classes are retrieved from {@see MachineMocks}.
 */

public abstract class TestBinaryInstruction extends MachineMocks {
    /**
     * A subclass of BinaryInstruction can test common functionality extending this test class
     * and passing its instance in the init() method to override.
     */
    private BinaryInstruction instruction;

    protected abstract BinaryInstruction init();

    // Set up the mocking classes --------------------------------------------------------------------------------------

    @Before
    public void setup() {
        /**
         * Get the implementation of BinaryInstruction running these tests, and set up the Mocks in {@see MachineMocks}
         */
        instruction = init();
        super.setupMocks();
    }

    // void execute(Machine) -----------------------------------------------------------------------------------------

    @Test
    public void testVarsShouldNotBeInitialisedBeforeRunningExecute() {
        assertThat(op1, nullValue());
        assertThat(op2, nullValue());
        assertThat(value1, nullValue());
        assertThat(value2, nullValue());
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
