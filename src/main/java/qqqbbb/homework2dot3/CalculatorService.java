package qqqbbb.homework2dot3;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService
{
    public String welcome()
    {
        return "Добро пожаловать в калькулятор";
    }

    public String addNumbers(int num1, int num2)
    {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public String subtractNumbers(int num1, int num2)
    {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiplyNumbers(int num1, int num2)
    {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public String divideNumbers(int num1, int num2)
    {
        return num1 + " / " + num2 + " = " + ((float)num1 / (float)num2);
    }
}
