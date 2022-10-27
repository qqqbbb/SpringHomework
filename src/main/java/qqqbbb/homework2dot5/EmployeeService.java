package qqqbbb.homework2dot5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService
{
    ArrayList<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName)
    {
        for (Employee employee : employees)
        {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
//            throw new EmployeeStorageIsFullException();
//        return "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\"}";
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName)
    {
        for (int i = 0; i < employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
            {
                employees.remove(i);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName)
    {
        for (Employee employee : employees)
        {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                return employee;
        }
        throw new EmployeeNotFoundException();
    }

    ArrayList<Employee> printEmployees()
    {
        return employees;
    }
}
