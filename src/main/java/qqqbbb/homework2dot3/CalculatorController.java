package qqqbbb.homework2dot3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController
{

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "/calculator")
    public String welcome()
    {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/calculator/plus")
    public String addNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.addNumbers(num1, num2);
    }

    @GetMapping(path = "/calculator/minus")
    public String subtractNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.subtractNumbers(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply")
    public String multiplyNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.multiplyNumbers(num1, num2);
    }

    @GetMapping(path = "/calculator/divide")
    public String divideNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.divideNumbers(num1, num2);
    }

}
