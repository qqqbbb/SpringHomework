package qqqbbb.Homework2dot10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeBook
{
    static HashMap<String, Employee> employees = new HashMap<>();

    public static void addNewEmployee(String firstName, String middleName, String lastName, int department, int salary)
    {
        Employee newEmployee = new Employee(firstName, middleName, lastName, department, salary);
        String fullName = newEmployee.getFullName();
        if (!employees.containsKey(fullName))
        {
            employees.put(fullName, newEmployee);
            Employee.count ++;
        }
        else
            throw new IllegalArgumentException(fullName + " already in database");
    }

    public static void removeEmployee(String firstName, String middleName, String lastName)
    {
        String fullName = firstName + ' ' + middleName + ' ' + lastName;
        Employee employee = employees.get(fullName);
        if (employees.containsKey(fullName))
        {
            employees.remove(fullName);
            Employee.count --;
        }
        else
            throw new IllegalArgumentException("No employee with name " + fullName);
    }

    public static void removeEmployee(int id)
    {
        String fullName = null;
        for (Employee employee: employees.values())
        {
            if (employee.id == id)
            {
                fullName = employee.getFullName();
                break;
            }
        }
        if (fullName != null)
        {
            employees.remove(fullName);
            Employee.count --;
        }
        else
            throw new IllegalArgumentException("No employee with ID " + id);
    }

    public static void modifyEmployeeData(String firstName, String middleName, String lastName, int newDepartment, int newSalary)
    {
        String fullName = firstName + ' ' + middleName + ' ' + lastName;

        if (employees.containsKey(fullName))
        {
            Employee employee = employees.get(fullName);
            employee.setDepartment(newDepartment);
            employee.setSalary(newSalary);
        }
        else
            throw new IllegalArgumentException("No employee with name " + fullName);
    }

    public static void printEmployeesByDepartment()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .forEach(e -> System.out.println(e));
    }

    public static void printEmployeesData()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        for (Employee employee: employees.values())
            System.out.println(employee);
    }

    public static void printMonthlySalaryTotal()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        int total = employees.values().stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        System.out.println("Total monthly salary: " + total);
    }

    public static void printLowestSalary()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        Stream stream = employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getSalary));

        Optional<Employee> employeeOptional =  stream.findFirst();
        Employee employee = employeeOptional.get();
        System.out.println(employee.getFullName() + " is on the lowest monthly salary of " + employee.getSalary());
    }

    public static void printHighestSalary()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> list = employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        Employee employee = list.get(list.size() -1);
        System.out.println(employee.getFullName() + " is on the highest monthly salary of " + employee.getSalary());
    }

    public static void printAverageSalary()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        int total = employees.values().stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        System.out.println("Average monthly salary is " + total/Employee.count);
    }

    public static void printEmployeesNames()
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        employees.values().stream()
                .forEach(e -> System.out.println(e.getFullName()));
    }

    public static void changeSalary(float percent)
    {
        for (Map.Entry<String, Employee> entry : employees.entrySet())
        {
            Employee employee = entry.getValue();
            if (employee == null)
                continue;

            int newSalary = (int)(employee.getSalary() * percent * .01f);
            employee.setSalary(newSalary);
        }
    }

    public static void printLowestSalaryInDepartment(int department)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        Stream<Employee> stream = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary));

        Optional<Employee> employeeOptional = stream.findFirst();
        if (employeeOptional.isEmpty())
        {
            System.out.println("No employees in department " + department);
            return;
        }
        Employee employee = employeeOptional.get();
        System.out.println(employee.getFullName() + " from " + department + " department is on the lowest monthly salary of " + employee.getSalary());
    }

    public static void printHighestSalaryInDepartment(int department)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> salaries = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (salaries.isEmpty())
        {
            System.out.println("No employees in department " + department);
            return;
        }
        Employee employee = salaries.get(salaries.size() -1);
        System.out.println(employee.getFullName() + " from " + department + " department is on the highest monthly salary of " + employee.getSalary());
    }

    public static void printSalaryTotalInDepartment(int department)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        int total = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        System.out.println("Total monthly salary in " + department + " department is " + total);
    }

    public static void printAverageSalaryInDepartment(int department)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> employeesInDepartment = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        int total = employeesInDepartment.stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        float average = total / employeesInDepartment.size();
        System.out.println("Average monthly salary in department " + department + " is " + average);
    }

    public static void changeSalaryInDepartment(float percent, int department)
    {
        for (Map.Entry<String, Employee> entry : employees.entrySet())
        {
            Employee employee = entry.getValue();
            if (employee == null)
                continue;

            if (employee.getDepartment() == department)
            {
                int newSalary = (int)(employee.getSalary() * percent * .01f);
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployeesDataInDepartment(int department)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> employeesInDepartment = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        if (employeesInDepartment.isEmpty())
        {
            System.out.println("No employees in department " + department);
            return;
        }
        System.out.println("Employees from department " + department);
        for (Employee employee: employeesInDepartment)
            System.out.println(employee.toString());
    }

    public static void printEmployeesWithSalaryLowerThan(int salary)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> employeesWithLowSalary = employees.values().stream()
                .filter(e -> e.getSalary() < salary)
                .collect(Collectors.toList());

        if (employeesWithLowSalary.isEmpty())
        {
            System.out.println("No employees with salary lower than " + salary);
            return;
        }
        System.out.println("Employees with salary lower than " + salary);
        for (Employee employee: employeesWithLowSalary)
            System.out.println(employee);
    }

    public static void printEmployeesWithSalaryHigherThan(int salary)
    {
        if (employees.keySet().isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        List<Employee> employeesWithHighSalary = employees.values().stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());

        if (employeesWithHighSalary.isEmpty())
        {
            System.out.println("No employees with salary higher than " + salary);
            return;
        }
        System.out.println("Employees with salary higher than " + salary);
        for (Employee employee: employeesWithHighSalary)
            System.out.println(employee);
    }

}
