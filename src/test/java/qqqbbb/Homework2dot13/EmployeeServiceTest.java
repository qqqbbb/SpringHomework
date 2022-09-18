package qqqbbb.Homework2dot13;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest
{
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void addEmployee()
    {
        Employee employee = employeeService.addEmployee("qWe", "erY");
        assertEquals(employee, new Employee("Qwe", "Ery"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("1", "erY"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee(null, "erY"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("erY", "  "));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("erY", ""));
        assert (EmployeeBook.employees.containsValue(employee));
        assertEquals(Employee.count , 1);
        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

    @Test
    void removeEmployee()
    {
        Employee employee = new Employee("Qqq", "Www");
        EmployeeBook.employees.put("Qqq Www", employee);
        Employee.count ++;
        assertThrows(IllegalArgumentException.class, () -> employeeService.removeEmployee("Www", "Qqq"));
        Employee removedEmployee = employeeService.removeEmployee("Qqq", "Www");
        assertEquals(employee, removedEmployee);
        assertEquals(Employee.count , 0);
        assertEquals(EmployeeBook.employees.size() , 0);
        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

    @Test
    void findEmployee()
    {
        Employee employee = new Employee("Qqq", "Www");
        EmployeeBook.employees.put("Qqq Www", employee);
        Employee.count ++;
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("1", "Www"));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee(null, "Www"));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("Qqq", "  "));
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee("Qqq", ""));
        Employee foundEmployee = employeeService.findEmployee("Qqq", "Www");
        assertEquals(employee, foundEmployee);
        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }

    @Test
    void printEmployees()
    {
        EmployeeBook.employees.put("Qqq Www", new Employee("Qqq", "Www"));
        EmployeeBook.employees.put("Aaa Sss", new Employee("Aaa", "Sss"));
        Employee.count += 2;
        List<Employee> list = EmployeeBook.employees.values().stream().collect(Collectors.toList());
        List<Employee> listToTest = employeeService.printEmployees();
        assertNotNull(listToTest);
        assertEquals(list, listToTest);
        Employee.count = 0;
        EmployeeBook.employees = new HashMap<>();
    }
}