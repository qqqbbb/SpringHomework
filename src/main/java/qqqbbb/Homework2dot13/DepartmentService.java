package qqqbbb.Homework2dot13;

import java.util.List;

public interface DepartmentService
{
    public Employee getEmployeeWithHighestSalaryInDepartment(int department);

    public Employee getEmployeeWithLowestSalaryInDepartment(int department);

    public List<Employee> getAllEmployeesInDepartment(int department);


}
