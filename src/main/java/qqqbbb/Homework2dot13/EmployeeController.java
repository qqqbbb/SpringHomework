package qqqbbb.Homework2dot13;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController
{
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @RequestMapping(path="/add")
    public Employee addEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.addEmployee(firstName, lastName);
    }

    @RequestMapping(path="/remove")
    public Employee removeEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @RequestMapping(path="/find")
    public Employee findEmployee(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")String lastName)
    {
        return employeeService.findEmployee(firstName, lastName);
    }

    @RequestMapping(path="/print")
    public List<Employee> printEmployees()
    {
        return employeeService.getEmployees();
    }


}
