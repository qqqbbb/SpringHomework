package qqqbbb.Homework2dot13;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest
{
//    @Mock
    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentService departmentService = new DepartmentService();

    @Test
    void getEmployeeWithHighestSalaryInDepartment()
    {
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithHighestSalaryInDepartment(1));
        Employee employee1 = new Employee("qqq", "www", "eee", 1, 111);
//        when(employeeService.addEmployee("qqq", "www", "eee", 1, 111)).thenReturn(employee1);
        String fullName = employee1.getFullName();
//        employeeService.addEmployee("qqq", "www", "eee", 1, 111);
        EmployeeBook.employees.put(fullName, employee1);

        Employee employee2 = new Employee("aaa", "sss", "ddd", 1, 222);
        fullName = employee2.getFullName();
//        when(employeeService.addEmployee("aaa", "sss", "ddd", 1, 222)).thenReturn(employee2);
//        employeeService.addEmployee("aaa", "sss", "ddd", 1, 222);
        EmployeeBook.employees.put(fullName, employee2);
        Employee employee3 = new Employee("zzz", "xxx", "ccc", 1, 333);
        fullName = employee3.getFullName();
//        when(employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333)).thenReturn(employee3);
//        employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333);
        EmployeeBook.employees.put(fullName, employee3);

        Employee.count += 3;
        Employee richestEmployee = departmentService.getEmployeeWithHighestSalaryInDepartment(1);
        assertEquals(employee3, richestEmployee);
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithHighestSalaryInDepartment(0));

        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

    @Test
    void getEmployeeWithLowestSalaryInDepartment()
    {
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithLowestSalaryInDepartment(1));
        Employee employee1 = new Employee("qqq", "www", "eee", 1, 111);
        String fullName = employee1.getFullName();
        EmployeeBook.employees.put(fullName, employee1);
        Employee employee2 = new Employee("aaa", "sss", "ddd", 1, 222);
        fullName = employee2.getFullName();
        EmployeeBook.employees.put(fullName, employee2);
        Employee employee3 = new Employee("zzz", "xxx", "ccc", 1, 333);
        fullName = employee3.getFullName();
        EmployeeBook.employees.put(fullName, employee3);
        Employee.count += 3;
        Employee poorestEmployee = departmentService.getEmployeeWithLowestSalaryInDepartment(1);
        assertEquals(employee1, poorestEmployee);
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithLowestSalaryInDepartment(0));

        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

    @Test
    void getAllEmployeesInDepartment()
    {
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithLowestSalaryInDepartment(1));
        Employee employee1 = new Employee("qqq", "www", "eee", 1, 111);
        String fullName = employee1.getFullName();
        EmployeeBook.employees.put(fullName, employee1);
        Employee employee2 = new Employee("aaa", "sss", "ddd", 1, 222);
        fullName = employee2.getFullName();
        EmployeeBook.employees.put(fullName, employee2);
        Employee employee3 = new Employee("zzz", "xxx", "ccc", 2, 333);
        fullName = employee3.getFullName();
        EmployeeBook.employees.put(fullName, employee3);
        Employee.count += 3;

        List<Employee> expectedList = Arrays.asList(employee1, employee2);
        List<Employee> listToTest = departmentService.getAllEmployeesInDepartment(1);
        assertNotNull(listToTest);
        assertEquals(expectedList, listToTest);
        assertThrows(RuntimeException.class, () -> departmentService.getAllEmployeesInDepartment(0));

        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

}