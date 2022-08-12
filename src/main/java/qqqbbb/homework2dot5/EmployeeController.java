package qqqbbb.homework2dot5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @RequestMapping(path="/employee/add")
    public Employee addEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.addEmployee(firstName, lastName);
    }

    @RequestMapping(path="/employee/remove")
    public Employee removeEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @RequestMapping(path="/employee/find")
    public Employee findEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.findEmployee(firstName, lastName);
    }

    @RequestMapping(path="/employee/print")
    public ArrayList<Employee> printEmployees()
    {
        return employeeService.printEmployees();
    }
}
