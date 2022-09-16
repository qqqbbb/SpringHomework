package qqqbbb.Homework2dot12;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController
{

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String welcome()
    {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/plus")
    public String addNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.addNumbers(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String subtractNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.subtractNumbers(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.multiplyNumbers(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam("num1") int num1, @RequestParam("num2")  int num2)
    {
        return calculatorService.divideNumbers(num1, num2);
    }

}
