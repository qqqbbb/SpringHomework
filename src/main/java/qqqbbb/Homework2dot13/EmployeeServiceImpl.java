package qqqbbb.Homework2dot13;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private final EmployeeBook employeeBook;
    public EmployeeServiceImpl(EmployeeBook employeeBook)
    {
        this.employeeBook = employeeBook;
    }

    public Employee addEmployee(String firstName, String lastName)
    {
        return employeeBook.addEmployee(firstName, lastName);
    }

    public Employee addEmployee(String firstName, String middleName, String lastName, int department, int salary)
    {
        return employeeBook.addEmployee(firstName, middleName, lastName, department, salary);
    }

    public Employee removeEmployee(String firstName, String lastName)
    {
        return employeeBook.removeEmployee(firstName, lastName);
    }

    public Employee findEmployee(String firstName, String lastName)
    {
            return employeeBook.findEmployee(firstName, lastName);
    }

    public List<Employee> getEmployees()
    {
        return employeeBook.getEmployees();
    }

    public boolean isEmployeeBookEmpty()
    {
        return employeeBook.isEmpty();
    }
}
