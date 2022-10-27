package qqqbbb.Homework2dot13;

import java.util.List;

public interface EmployeeService
{
    public Employee addEmployee(String firstName, String lastName);

    public Employee addEmployee(String firstName, String middleName, String lastName, int department, int salary);

    public Employee removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

    public List<Employee> getEmployees();

    public boolean isEmployeeBookEmpty();
}
