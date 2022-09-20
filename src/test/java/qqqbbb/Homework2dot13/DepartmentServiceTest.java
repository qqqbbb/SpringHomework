package qqqbbb.Homework2dot13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest
{
    @Mock
    EmployeeBook employeeBook = new EmployeeBook();
    @Mock
    private final EmployeeService employeeService = new EmployeeService(employeeBook);
    @InjectMocks
    private final DepartmentService departmentService = new DepartmentService(employeeBook);

    @Test
    void getEmployeeWithHighestSalaryInDepartmentTest()
    {
//        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithHighestSalaryInDepartment(1));
        Employee employee1 = new Employee("qqq", "www", "eee", 1, 111);
        Employee employee2 = new Employee("aaa", "sss", "ddd", 1, 222);
        Employee employee3 = new Employee("zzz", "xxx", "ccc", 1, 333);
        when(employeeService.addEmployee("qqq", "www", "eee", 1, 111))
                .thenReturn(employee1);
        when(employeeService.addEmployee("aaa", "sss", "ddd", 1, 222))
                .thenReturn(employee2);
        when(employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333))
                .thenReturn(employee3);
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        when(employeeBook.getEmployees()).thenReturn(list);
        when(employeeBook.isEmpty()).thenReturn(false);
        employeeService.addEmployee("qqq", "www", "eee", 1, 111);
        employeeService.addEmployee("aaa", "sss", "ddd", 1, 222);
        employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333);
//        System.out.println("" + employeeBook.getEmployees());
        Employee richestEmployee = departmentService.getEmployeeWithHighestSalaryInDepartment(1);
        assertEquals(employee3, richestEmployee);
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithHighestSalaryInDepartment(0));
        employeeBook = new EmployeeBook();
    }

    @Test
    void getEmployeeWithLowestSalaryInDepartment()
    {
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithLowestSalaryInDepartment(1));
        when(employeeService.addEmployee(anyString(), anyString(), anyString(), anyInt(), anyInt()))
                .thenCallRealMethod();
        Employee employee1 = employeeService.addEmployee("qqq", "www", "eee", 1, 111);
        Employee employee2 = employeeService.addEmployee("aaa", "sss", "ddd", 1, 222);
        Employee employee3 = employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333);

        Employee poorestEmployee = departmentService.getEmployeeWithLowestSalaryInDepartment(1);
        assertEquals(employee1, poorestEmployee);
        assertThrows(RuntimeException.class, () -> departmentService.getEmployeeWithLowestSalaryInDepartment(0));
        employeeBook = new EmployeeBook();
    }

    @Test
    void getAllEmployeesInDepartment()
    {
        assertThrows(RuntimeException.class, () -> departmentService.getAllEmployeesInDepartment(1));
        when(employeeService.addEmployee(anyString(), anyString(), anyString(), anyInt(), anyInt()))
                .thenCallRealMethod();
        Employee employee1 = employeeService.addEmployee("qqq", "www", "eee", 1, 111);
        Employee employee2 = employeeService.addEmployee("aaa", "sss", "ddd", 1, 222);
        Employee employee3 = employeeService.addEmployee("zzz", "xxx", "ccc", 2, 333);

        List<Employee> expectedList = Arrays.asList(employee1, employee2);
        List<Employee> listToTest = departmentService.getAllEmployeesInDepartment(1);
        assertNotNull(listToTest);
        assertIterableEquals(expectedList, listToTest);
        assertNotEquals(expectedList, departmentService.getAllEmployeesInDepartment(2));
        assertThrows(RuntimeException.class, () -> departmentService.getAllEmployeesInDepartment(0));
        employeeBook = new EmployeeBook();
    }

}