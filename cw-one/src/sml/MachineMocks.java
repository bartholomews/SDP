package sml;

import java.util.Random;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Class for unit testing, setting up the mocks used by the other subclasses tests;
 */

public class MachineMocks {

    // a Machine mock class with underlying randomRegs (Registers mock class with random regs values)
    Machine randomMachine;
    // a Machine mock class with underlying zeroRegs (Registers mock class with regs values always zero)
    Machine zeroMachine;
    // the argument of first call Registers.getRegister(int i)
    Integer op1;
    // the argument of second call Registers.getRegister(int i)
    Integer op2;
    // the value returned from first call Registers.getRegister(int i)
    Integer value1;
    // the value returned from second call Registers.getRegister(int i)
    Integer value2;
    // the arguments of method call Registers.setRegister(int i, int v)
    Object[] args;
    // the argument of method call Labels.indexOf(String s)
    String statement;
    // a random int returned from method call Labels.indexOf(String s) with valid Label (invalid always returns -1)
    Integer index;
    // the argument of method call Machine.setPc(int v)
    Integer pcSet;

    // Set up the mocking classes --------------------------------------------------------------------------------------

    // set up mocks with valid Labels
    public void setupMocks() {
        setupMocks(getValidLabels());
    }

    // set up mocks with custom Labels (see TestBnzInstruction)
    public void setupMocks(Labels l) {
        randomMachine = mock(Machine.class);
        Registers random = getRandomRegs();
        when(randomMachine.getRegisters()).thenReturn(random);
        when(randomMachine.getLabels()).thenReturn(l);
        doAnswer(invocation -> {
            pcSet = (Integer) invocation.getArguments()[0];
            return null;
        }).when(randomMachine).setPc(anyInt());

        zeroMachine = mock(Machine.class);
        Registers zeroes = getZeroRegs();
        when(zeroMachine.getRegisters()).thenReturn(zeroes);
        when(zeroMachine.getLabels()).thenReturn(l);
        doAnswer(invocation -> {
            pcSet = (Integer) invocation.getArguments()[0];
            return null;
        }).when(zeroMachine).setPc(anyInt());
    }

    public Registers getRandomRegs() {
        // to generate random registers values
        Random random = new Random();

        // mock Registers class which returns random values
        Registers randomRegs = mock(Registers.class);

        /* when getRegister is called, assign invocation arguments
          to op1 and op2 for first and second call respectively;
          the value of the registers returned (a random int)
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
                    } while (value2 == 0);
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                });

        /* when Registers.setRegister(int i, int v) is called,
         invocation arguments are assigned to variable args
         to be checked against the operation that should have been performed;
         note: doAnswer is necessary here because setRegister() returns void;
        */
        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(randomRegs).setRegister(anyInt(), anyInt());

        return randomRegs;
    }

    public Registers getZeroRegs() {
        // mock Registers class which always returns values 0s
        Registers zeroRegs = mock(Registers.class);

        /* when getRegister is called, assign invocation arguments
          to op1 and op2 for first and second call respectively;
          the value of the registers returned (always zero)
          is assigned to vars value1 and value2 for first and second call respectively.
        */
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
                });

        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(zeroRegs).setRegister(anyInt(), anyInt());

        return zeroRegs;
    }

    public Labels getValidLabels() {

        // Labels mock class which returns an valid label (see TestBnzInstruction)
        Labels validLabel = mock(Labels.class);
        when(validLabel.indexOf(anyString()))
                .thenAnswer(invocation -> {
                    // store the argument of method call for testing purposes
                    statement = (String) invocation.getArguments()[0];
                    // return any int != -1
                    do {
                        index = new Random().nextInt();
                    } while(index == -1);
                    return index;
                });
        return validLabel;
    }

    public Labels getUnknownLabels() {
        // Labels mock class which returns an unknown label (see TestBnzInstruction)
        Labels unknownLabels = mock(Labels.class);
        when(unknownLabels.indexOf(anyString()))
                .thenAnswer(invocation -> {
                    // store the argument of method call for testing purposes
                    statement = (String) invocation.getArguments()[0];
                    return -1;
                });
        return unknownLabels;
    }

}
