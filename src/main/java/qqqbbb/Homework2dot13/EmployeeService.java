package qqqbbb.Homework2dot13;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{

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

    public Employee addEmployee(String firstName, String middleName, String lastName, int department, int salary)
    {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName))
            throw new BadRequestException();

        firstName = StringUtils.lowerCase(firstName);
        lastName = StringUtils.lowerCase(lastName);
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        Employee newEmployee = new Employee(firstName, middleName, lastName, department, salary);
        String fullName = newEmployee.getFullName();

        if (EmployeeBook.employees.containsKey(fullName))
            throw new EmployeeAlreadyAddedException();

        EmployeeBook.employees.put(fullName, newEmployee);
        Employee.count++;
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
        return new ArrayList<>(EmployeeBook.employees.values());
    }

}
