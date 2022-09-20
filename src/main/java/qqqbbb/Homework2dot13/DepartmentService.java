package qqqbbb.Homework2dot13;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentService
{
    private final EmployeeBook employeeBook;

    public DepartmentService(EmployeeBook employeeBook)
    {
        this.employeeBook = employeeBook;
    }

    public Employee getEmployeeWithHighestSalaryInDepartment(int department)
    {
        if (employeeBook.isEmpty())
//            System.out.println("getEmployeeWithHighestSalaryInDepartment empty");
            throw new EmployeeNotFoundException();

        List<Employee> employees = employeeBook.getEmployees();
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
        if (employeeBook.isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employees = employeeBook.getEmployees();
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
        if (employeeBook.isEmpty())
            throw new RuntimeException("No employees");

        List<Employee> employees = employeeBook.getEmployees();
        List<Employee> employeesFiltered = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        if (employeesFiltered.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employeesFiltered;
    }

    public List<Employee> getAllEmployees()
    {
        return employeeBook.getEmployees();
    }

}
