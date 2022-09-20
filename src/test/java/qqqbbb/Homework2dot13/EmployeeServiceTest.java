package qqqbbb.Homework2dot13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest
{
//    @Mock
    EmployeeBook employeeBook = new EmployeeBook();
    private final EmployeeService employeeService = new EmployeeService(employeeBook);

    @Test
    void addEmployee()
    {
//        when(employeeService.addEmployee("zzz", "xxx", "ccc", 1, 333)).thenReturn(employee3);
        Employee employee = employeeService.addEmployee("qWe", "erY");
        assertEquals(employee, new Employee("Qwe", "Ery"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("1", "erY"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee(null, "erY"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("erY", "  "));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("erY", ""));
//        assert (EmployeeBook.repository.containsValue(employee));
        assertEquals(employeeBook.size(), 1);
        employeeBook = new EmployeeBook();
    }

    @Test
    void removeEmployee()
    {
        Employee employee = employeeService.addEmployee("Qqq", "Www");
        assertThrows(IllegalArgumentException.class, () -> employeeService.removeEmployee("Www", "Qqq"));
        Employee removedEmployee = employeeService.removeEmployee("Qqq", "Www");
        assertEquals(employee, removedEmployee);
        assertEquals(employeeBook.size() , 0);
        employeeBook = new EmployeeBook();
    }

    @Test
    void findEmployee()
    {
        Employee employee = employeeService.addEmployee("Qqq", "Www");
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("1", "Www"));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee(null, "Www"));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("Qqq", "  "));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("Qqq", ""));
        Employee foundEmployee = employeeService.findEmployee("Qqq", "Www");
        assertEquals(employee, foundEmployee);
        employeeBook = new EmployeeBook();
    }

    @Test
    void getEmployees()
    {
        Employee employee2 = employeeService.addEmployee("Aaa", "Sss");
        Employee employee1 = employeeService.addEmployee("Qqq", "Www");
        List<Employee> list = Arrays.asList(new Employee[]{employee2, employee1});
//        System.out.println(list);
        List<Employee> listToTest = employeeService.getEmployees();
//        System.out.println(listToTest);
        assertNotNull(listToTest);
        assertIterableEquals(list, listToTest);
        employeeBook = new EmployeeBook();
    }
}