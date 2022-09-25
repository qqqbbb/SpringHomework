package qqqbbb.Homework2dot13;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService
{
    private final EmployeeService employeeService;


    public DepartmentServiceImpl(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithHighestSalaryInDepartment(int department)
    {
        if (employeeService.isEmployeeBookEmpty())
            System.out.println("getEmployeeWithHighestSalaryInDepartment empty");
//            throw new EmployeeNotFoundException();

        List<Employee> employees = employeeService.getEmployees();
//        System.out.println("getEmployeeWithHighestSalaryInDepartment employees size "+ employees.size());
        employees = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (employees.isEmpty())
            throw new RuntimeException("No employees in department " + department);

//            System.out.println(employee.getFullName() + " from " + department + " department is on the highest monthly salary of " + employee.getSalary());
        return employees.get(employees.size() -1);
    }

    public Employee getEmployeeWithLowestSalaryInDepartment(int department)
    {
        if (employeeService.isEmployeeBookEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employees = employeeService.getEmployees();
        List<Employee> employeesFiltered = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (employeesFiltered.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employeesFiltered.get(0);
//        System.out.println(employee.getFullName() + " from " + department + " department is on the lowest monthly salary of " + employee.getSalary());

    }

    public List<Employee> getAllEmployeesInDepartment(int department)
    {
        if (employeeService.isEmployeeBookEmpty())
            throw new RuntimeException("No employees");

        List<Employee> employeesFiltered = employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

//        System.out.println(employeesFiltered.size() + " Employees In Department " + department);
        if (employeesFiltered.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employeesFiltered;
    }

}
