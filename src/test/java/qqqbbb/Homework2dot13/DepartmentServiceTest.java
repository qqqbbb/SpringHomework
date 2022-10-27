package qqqbbb.Homework2dot13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest
{
//    @Mock
//    EmployeeBook employeeBook = new EmployeeBook();
    @Mock
    private  EmployeeService employeeService ;
    @InjectMocks
    private  DepartmentServiceImpl out;

    Employee employee1 = new Employee("qqq", "www", "eee", 1, 111);
    Employee employee2 = new Employee("aaa", "sss", "ddd", 1, 222);
    Employee employee3 = new Employee("zzz", "xxx", "ccc", 1, 333);
    Employee employee4 = new Employee("vvv", "bbb", "nnn", 2, 444);

    List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4);
    @BeforeAll
    static void setup()
    {

    }

    @Test
    void getEmployeeWithHighestSalaryInDepartmentTest()
    {
        assertThrows(RuntimeException.class, () -> out.getEmployeeWithHighestSalaryInDepartment(1));
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        when(employeeService.getEmployees()).thenReturn(list);
        when(employeeService.isEmployeeBookEmpty()).thenReturn(false);
//        System.out.println("departmentService " + employeeService.getEmployees());
        Employee richestEmployee = out.getEmployeeWithHighestSalaryInDepartment(1);
        assertEquals(employee3, richestEmployee);
        assertThrows(RuntimeException.class, () -> out.getEmployeeWithHighestSalaryInDepartment(0));
    }

    @Test
    void getEmployeeWithLowestSalaryInDepartment()
    {
        assertThrows(RuntimeException.class, () -> out.getEmployeeWithLowestSalaryInDepartment(1));
        when(employeeService.getEmployees()).thenReturn(employeeList);
        when(employeeService.isEmployeeBookEmpty()).thenReturn(false);
        Employee richestEmployee = out.getEmployeeWithLowestSalaryInDepartment(1);
        assertEquals(employee1, richestEmployee);
        assertThrows(RuntimeException.class, () -> out.getEmployeeWithLowestSalaryInDepartment(0));
    }

    @Test
    void getAllEmployeesInDepartment()
    {
        assertThrows(RuntimeException.class, () -> out.getAllEmployeesInDepartment(1));
        when(employeeService.getEmployees()).thenReturn(employeeList);
        when(employeeService.isEmployeeBookEmpty()).thenReturn(false);
        List<Employee> expectedList = Arrays.asList(employee1, employee2, employee3);
        List<Employee> listToTest = out.getAllEmployeesInDepartment(1);
        assertNotNull(listToTest);
        assertIterableEquals(expectedList, listToTest);
        assertNotEquals(expectedList, out.getAllEmployeesInDepartment(2));
        assertThrows(RuntimeException.class, () -> out.getAllEmployeesInDepartment(0));
    }

}