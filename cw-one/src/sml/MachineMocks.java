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

    // Set up the mocking classes --------------------------------------------------------------------------------------

    public void setupMocks() {
        // to generate random registers values
        Random random = new Random();

        // mock Registers class which always returns values 0s
        Registers zeroRegs = mock(Registers.class);

        // mock Registers class which returns random values
        Registers randomRegs = mock(Registers.class);

        /* when getRegister is called, assign invocation arguments
          to op1 and op2 for first and second call respectively;
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
                    } while (value2 == 0);
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                });

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

}
