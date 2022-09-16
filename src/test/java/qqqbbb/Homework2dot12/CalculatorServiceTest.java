package qqqbbb.Homework2dot12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest
{
    private final CalculatorService out = new CalculatorService();

    @Test
    void addNumbers()
    {
        assertEquals(out.addNumbers(2, 2).toString(),"2 + 2 = 4");
        assertEquals(out.addNumbers(-2,-2).toString(),"-2 + -2 = -4");
    }

    @Test
    void subtractNumbers()
    {
        assertEquals(out.subtractNumbers(2, 2).toString(),"2 - 2 = 0");
        assertEquals(out.subtractNumbers(-2,-2).toString(),"-2 - -2 = 0");
    }

    @Test
    void multiplyNumbers()
    {
        assertEquals(out.multiplyNumbers(2, 2).toString(),"2 * 2 = 4");
        assertEquals(out.multiplyNumbers(-2,-2).toString(),"-2 * -2 = 4");
    }

    @Test
    void divideNumbers()
    {
        assertEquals(out.divideNumbers(2, 2).toString(),"2 / 2 = 1.0");
        assertEquals(out.divideNumbers(-2,-2).toString(),"-2 / -2 = 1.0");
        assertThrows(DivisionByZeroException.class, () -> out.divideNumbers(1, 0));
    }
}