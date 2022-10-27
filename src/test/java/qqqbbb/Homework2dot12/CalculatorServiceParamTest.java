package qqqbbb.Homework2dot12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParamTest
{
    private final CalculatorService out = new CalculatorService();

    @ParameterizedTest
    @MethodSource("provideParamsForAdditionTest")
    void addNumbersParamTest(int num1, int num2, String expectedResult)
    {
        String result = out.addNumbers(num1, num2);
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSubtractionTest")
    void subtractNumbersParamTest(int num1, int num2, String expectedResult)
    {
        String result = out.subtractNumbers(num1, num2);
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplicationTest")
    void multiplyNumbersParamTest(int num1, int num2, String expectedResult)
    {
        String result = out.multiplyNumbers(num1, num2);
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivisionTest")
    void divideNumbersParamTest(int num1, int num2, String expectedResult)
    {
        String result = out.divideNumbers(num1, num2);
        assertEquals(result, expectedResult);
    }

    static Stream<Arguments> provideParamsForAdditionTest()
    {
        return Stream.of(
                Arguments.of(2, 2, "2 + 2 = 4"),
                Arguments.of(-2, -2, "-2 + -2 = -4")
        );
    }

    static Stream<Arguments> provideParamsForSubtractionTest()
    {
        return Stream.of(
                Arguments.of(2, 2, "2 - 2 = 0"),
                Arguments.of(-2, -2, "-2 - -2 = 0")
        );
    }

    static Stream<Arguments> provideParamsForMultiplicationTest()
    {
        return Stream.of(
                Arguments.of(2, 2, "2 * 2 = 4"),
                Arguments.of(-2, -2, "-2 * -2 = 4")
        );
    }

    static Stream<Arguments> provideParamsForDivisionTest()
    {
        return Stream.of(
                Arguments.of(2, 2, "2 / 2 = 1.0"),
                Arguments.of(-2, -2, "-2 / -2 = 1.0")
        );
    }
}