package qqqbbb.Homework2dot10;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
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

    public List<String> getAllEmployeesByDepartment()
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

    public Employee addEmployee(String firstName, String lastName)
    {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName))
            throw new BadRequestException();

        firstName = StringUtils.lowerCase(firstName);
        lastName = StringUtils.lowerCase(lastName);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        String fullName = firstName + ' ' + lastName;

        if (EmployeeBook.employees.containsKey(fullName))
            throw new EmployeeAlreadyAddedException();

        Employee newEmployee = new Employee(firstName, lastName);
        EmployeeBook.employees.put(fullName, newEmployee);
        Employee.count ++;
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName)
    {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName))
            throw new BadRequestException();

        firstName = StringUtils.lowerCase(firstName);
        lastName = StringUtils.lowerCase(lastName);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        String fullName = firstName + ' ' + lastName;

        if (EmployeeBook.employees.containsKey(fullName))
        {
            Employee employee = EmployeeBook.employees.get(fullName);
            EmployeeBook.employees.remove(fullName);
            Employee.count --;
            return employee;
        }
        else
            throw new IllegalArgumentException("No employee with name " + fullName);
    }

    public Employee findEmployee(String firstName, String lastName)
    {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName))
            throw new BadRequestException();

        firstName = StringUtils.lowerCase(firstName);
        lastName = StringUtils.lowerCase(lastName);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        String fullName = firstName + ' ' + lastName;
        if (EmployeeBook.employees.containsKey(fullName))
            return EmployeeBook.employees.get(fullName);

        throw new EmployeeNotFoundException();
    }

    List<Employee> printEmployees()
    {
        return EmployeeBook.employees.values().stream().collect(Collectors.toList());
    }

}
