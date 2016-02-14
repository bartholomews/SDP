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
 * Test class for AddInstruction
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
          a successive call would throw an exception as for this instruction
          it should call getRegister twice to get the content of two registers only;
          the value of the registers returned are assigned to vars value1 and value2
          for first and second call respectively, to be checked against the
          setRegister method which should add them up;
          compiler warns for unchecked generics array creation for varargs parameter here;
        */
        when(r.getRegister(anyInt()))

                .thenAnswer(invocation1 -> {
                    value1 = random.nextInt(100);
                    op1 = (Integer) invocation1.getArguments()[0];
                    return value1;
                })

                .thenAnswer(invocation2 -> {
                    value2 = random.nextInt(100);
                    op2 = (Integer) invocation2.getArguments()[0];
                    return value2;
                })

                .thenThrow(IllegalArgumentException.class);

        /* when Registers.setRegister(int i, int v) is called,
         invocation arguments are assigned to variables index and value
         to be checked against the operation that should have been performed;
        */
        doAnswer(invocation -> {
            args = invocation.getArguments();
            return null;
        }).when(r).setRegister(anyInt(), anyInt());

        // mock Machine class
        m = mock(Machine.class);
        when(m.getRegisters()).thenReturn(r);
    }

    @Test
    public void testExecuteShouldGetTheRegistersAtRightIndexes() {
        // should get registers at index 10 and 20
        new AddInstruction("f1", 0, 10, 20).execute(m);
        assertThat(op1, is(10));
        assertThat(op2, is(20));
    }

    @Test
    public void testExecuteShouldSetRegisterAtRightIndex() {
        // should set register 10
        Instruction test = new AddInstruction("f2", 10, 0, 1);
        test.execute(m);
        assertThat(args[0], is(10));
    }

    @Test
    public void testExecuteShouldSetRegisterAtRightIndexWithRightValue() {
        // should set register 99 (with values of registers 100 and 123)
        new AddInstruction("f3", 99, 100, 123).execute(m);
        // the sum of values in registers 100 and 123
        System.out.println("Register[100] = " + value1);
        System.out.println("Register[123] = " + value2);
        int result = value1 + value2;
        // should go to register 99
        assertThat(args[0], is(99));
        // and have the right value
        System.out.println("Set Register[99] with value " + result);
        assertThat(args[1], is(result));
    }

    @Test
    public void testExecuteShouldSetRegister1() {
        new AddInstruction("f1", 1, 2, 3).execute(m);
        assertThat(args[0], is(1));
    }


}
