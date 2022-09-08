package qqqbbb.Homework2dot8;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    public Employee GetEmployeeWithHighestSalaryInDepartment(int department)
    {
        if (EmployeeBook.employees.keySet().isEmpty())
            throw new RuntimeException("No employees");

        List<Employee> employees = EmployeeBook.employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (employees.isEmpty())
            throw new RuntimeException("No employees in department " + department);

//            System.out.println(employee.getFullName() + " from " + department + " department is on the highest monthly salary of " + employee.getSalary());
        return employees.get(employees.size() -1);
    }

    public Employee GetEmployeeWithLowestSalaryInDepartment(int department)
    {
        if (EmployeeBook.employees.keySet().isEmpty())
            throw new RuntimeException("No employees");

        List<Employee> employees = EmployeeBook.employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (employees.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employees.get(0);
    }

    public List<Employee>  GetAllEmployeesInDepartment(int department)
    {
        if (EmployeeBook.employees.keySet().isEmpty())
            throw new RuntimeException("No employees");

        List<Employee> employees = EmployeeBook.employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        if (employees.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employees;
    }

    public List<String> GetAllEmployeesByDepartment()
    {
        if (EmployeeBook.employees.keySet().isEmpty())
            throw new RuntimeException("No employees");

        List<String> returnedList = new ArrayList<>();
        List<Employee> sortedList = EmployeeBook.employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());

        int department = -1;
        for (Employee employee: sortedList)
        {
            if (department != employee.getDepartment())
            {
                department = employee.getDepartment();
                returnedList.add("Employees in department " + department);
            }
            returnedList.add(employee.toString());
        }
        return returnedList;
    }

}
