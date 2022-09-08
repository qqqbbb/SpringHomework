package qqqbbb.Homework2dot10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/departments")
@RestController
public class EmployeeController
{
    final private EmployeeService employeeService;

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
    public List<Employee> printEmployees()
    {
        return employeeService.printEmployees();
    }

    @GetMapping(path="/departments/max-salary")
    public Employee GetEmployeeWithHighestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.GetEmployeeWithHighestSalaryInDepartment(department);
    }

    @GetMapping(path="/departments/min-salary")
    public Employee GetEmployeeWithLowestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.GetEmployeeWithLowestSalaryInDepartment(department);
    }

    @GetMapping(value = "/departments/all", params = "departmentId")
    public List<Employee> GetAllEmployeesInDepartment(@RequestParam(name = "departmentId") Integer department)
    {
        return employeeService.GetAllEmployeesInDepartment(department);
    }

    @GetMapping(path="/departments/all")
    public List<String> GetAllEmployeesInDepartment()
    {
        return employeeService.GetAllEmployeesByDepartment();
    }

}
