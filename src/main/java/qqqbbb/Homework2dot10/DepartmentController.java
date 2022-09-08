package qqqbbb.Homework2dot10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController
{
    final private EmployeeService employeeService;

    public DepartmentController( EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/max-salary")
    public Employee getEmployeeWithHighestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.getEmployeeWithHighestSalaryInDepartment(department);
    }

    @GetMapping(path="/min-salary")
    public Employee getEmployeeWithLowestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.getEmployeeWithLowestSalaryInDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllEmployeesInDepartment(@RequestParam(name = "departmentId") Integer department)
    {
        return employeeService.getAllEmployeesInDepartment(department);
    }

    @GetMapping(path="/all")
    public List<String> getAllEmployeesInDepartment()
    {
        return employeeService.getAllEmployeesByDepartment();
    }

}
