package sml;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Unit test class for BnzInstruction.
 * Please refer to {@see MachineMocks} for details about the the mocking classes (Machine and Registers)
 * and the arguments and return values of methods in the execute() functionality.
 *
 * @author federico.bartolomei
 */
public class TestBnzInstruction extends MachineMocks {
    // mock Machine returning random register values and returning valid Labels (i.e. indexOf(anyString) != -1)
    Machine validRandom;
    // mock Machine returning random register values and returning unknown Labels (i.e. indexOf(anyString) == -1)
    Machine invalidRandom;
    // mock Machine returning register values always 0 and returning valid Labels
    Machine validZero;
    // mock Machine returning register values always 0 and returning unknown Labels
    Machine invalidZero;

    @Before
    public void setup() {
        // create random and zero Machine mocks with valid Labels
        super.setupMocks(getValidLabels());
        validRandom = randomMachine;
        validZero = zeroMachine;

        // create random and zero Machine mocks with unknown Labels
        super.setupMocks(getUnknownLabels());
        invalidRandom = randomMachine;
        invalidZero = zeroMachine;
    }

    // void execute(Machine m) -----------------------------------------------------------------------------------------

    @Test
    public void testExecuteShouldGetTheRightRegister() {
        new BnzInstruction("f0", 10, "f1").execute(validRandom);
        // the parameter passed in Registers.getRegister(int i)
        int i = op1;
        // should be 10, the number of the register in the test instruction
        assertThat(i, is(10));
    }

    @Test
    public void testExecuteRegisterValueNotZeroShouldSetPc() {
        new BnzInstruction("f0", 0, "validLabel").execute(validRandom);
        // Machine.setPc(int v) should have been called
        assertThat(pcSet, notNullValue());
    }

    @Test
    public void testExecuteRegisterValueZeroShouldNotSetPc() {
        new BnzInstruction("f0", 0, "validLabel").execute(validZero);
        // Machine.setPc(int v) should not have been called
        assertThat(pcSet, nullValue());
    }

    @Test
    public void testExecuteRegisterValueZeroValidLabelShouldCheckTheRightLabel() {
        new BnzInstruction("f1", 1, "someValidLabel").execute(validZero);
        // the arg of method call Labels.indexOf(s)
        assertThat(statement, is("someValidLabel"));
    }

    @Test
    public void testExecuteRegisterValueNotZeroValidLabelShouldCheckTheRightLabel() {
        new BnzInstruction("f2", 2, "someValidLabel").execute(validRandom);
        // the arg of method call Labels.indexOf(s)
        assertThat(statement, is("someValidLabel"));
    }

    @Test
    public void testExecuteRegisterValueNotZeroUnknownLabelShouldNotSetPc() {
        new BnzInstruction("f3", 3, "invalidLabel").execute(invalidRandom);
        // Machine.setPc(int v) should not have been called
        assertThat(pcSet, nullValue());
    }

    @Test
    public void testExecuteRegisterValueZeroUnknownLabelShouldNotSetPc() {
        new BnzInstruction("f4", 4, "invalidLabel").execute(invalidZero);
        // Machine.setPc(int v) should not have been called
        assertThat(pcSet, nullValue());
    }

    @Test
    public void testExecuteRegisterValueZeroValidLabelShouldSetPcAtTheRightIndex() {
        new BnzInstruction("f5", 5, "validLabel").execute(validRandom);
        // The argument of Machine.setPc(int v) should be equal to the int returned from Labels.indexOf("validLabel")
        assertThat(pcSet, is(index));
    }

    // String toString() -----------------------------------------------------------------------------------------------

    @Test
    public void testToStringShouldHaveCorrectLabelAndOpCode() {
        Instruction i = new BnzInstruction("f0", 0, "f10");
        String s = i.toString();
        assertThat(s, containsString("f0: bnz"));
    }

    @Test
    public void testToStringShouldHaveCorrectOperatorsAndResult() {
        Instruction i = new BnzInstruction("f1", 10, "f10");
        String s = i.toString();
        assertThat(s, containsString("register 10 to f10"));
    }

    @Test
    public void testToStringShouldHaveCorrectLabelOpcodeOperatorsAndResult() {
        Instruction i = new BnzInstruction("f2", 20, "f20");
        String s = i.toString();
        assertThat(s, containsString("f2: bnz register 20 to f20"));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
