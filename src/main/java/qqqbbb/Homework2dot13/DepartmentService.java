package qqqbbb.Homework2dot13;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService
{
    public Employee getEmployeeWithHighestSalaryInDepartment(int department)
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

    public Employee getEmployeeWithLowestSalaryInDepartment(int department)
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

    public List<Employee> getAllEmployeesInDepartment(int department)
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

    public List<String> getAllEmployees()
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
                returnedList.add("\n");
                department = employee.getDepartment();
                returnedList.add("Employees in department " + department);
                returnedList.add("\n");
            }
            returnedList.add(employee.toString());
            returnedList.add("\n");
        }
        return returnedList;
    }

}
