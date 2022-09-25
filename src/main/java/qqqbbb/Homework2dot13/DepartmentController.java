package qqqbbb.Homework2dot13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController
{
    final private DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService)
    {
        this.departmentService = departmentService;
    }

    @GetMapping(path="/max-salary")
    public Employee getEmployeeWithHighestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return departmentService.getEmployeeWithHighestSalaryInDepartment(department);
    }

    @GetMapping(path="/min-salary")
    public Employee getEmployeeWithLowestSalaryInDepartment(@RequestParam(name = "departmentId") int department)
    {
        return departmentService.getEmployeeWithLowestSalaryInDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllEmployeesInDepartment(@RequestParam(name = "departmentId") Integer department)
    {
        return departmentService.getAllEmployeesInDepartment(department);
    }

//    @GetMapping(path="/all")
//    public List<Employee> getAllEmployees()
//    {
//        return departmentService.;
//    }

}
