package sml;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

/**
 *
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
          a successive call would throw an exception as for this instruction
          it should call getRegister twice to get the content of two registers only;
          the value of the registers returned are assigned to vars value1 and value2
          for first and second call respectively, to be checked against the
          setRegister method which should add them up;
          compiler warns for unchecked generics array creation for varargs parameter here;
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

                .thenThrow(IllegalArgumentException.class);



        // when Registers.setRegister(int i, int v) is called,
        // invocation arguments are assigned to variables index and value
        // to be checked against the operation that should have been performed;
        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(r).setRegister(anyInt(), anyInt());

        // mock Machine class
        m = mock(Machine.class);
        when(m.getRegisters()).thenReturn(r);
    }

    @Test
    public void testExecuteShouldSetRegister10() {
        Instruction test1 = new AddInstruction("f1", 10, 0, 1);
        test1.execute(m);
        assertThat(args[0], is(10));
    }

    @Test
    public void testExecute2() {
        Instruction test = new AddInstruction("f1", 1, 2, 3);
        test.execute(m);
        assertThat(args[0], is(1));
    }


}
