package qqqbbb.Homework2dot8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/departments")
@RestController
public class EmployeeController
{
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/max-salary")
    public Employee GetEmployeeWithHighestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.GetEmployeeWithHighestSalaryInDepartment(department);
    }

    @GetMapping(path="/min-salary")
    public Employee GetEmployeeWithLowestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return employeeService.GetEmployeeWithLowestSalaryInDepartment(department);
    }

    @GetMapping(path="/all")
    public List<String> GetAllEmployeesInDepartment(@RequestParam(name = "departmentId", required = false) Integer department)
    {
        if (department != null)
            return employeeService.GetAllEmployeesInDepartment(department);
        else
            return employeeService.GetAllEmployeesByDepartment();
    }

}
