package qqqbbb.Homework2dot13;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmployeeBook
{
    private HashMap<String, Employee> repository;

    public EmployeeBook()
    {
        this.repository = new HashMap<>();
    }

    public boolean isEmpty()
    {
        return repository.isEmpty();
    }

    public int size()
    {
        return repository.size();
    }

    private String validateName(String name)
    {
//        System.out.println("validateName " + name);
        if (!StringUtils.isAlpha(name))
            throw new BadRequestException();

        name = StringUtils.lowerCase(name);
        name = StringUtils.capitalize(name);
        return name;
    }

    public Employee addEmployee(String firstName, String lastName)
    {
        firstName = validateName(firstName);
        lastName = validateName(lastName);
        String fullName = firstName + ' ' + lastName;

        if (repository.containsKey(fullName))
            throw new EmployeeAlreadyAddedException();

        Employee newEmployee = new Employee(firstName, lastName);
        newEmployee.setId(repository.size());
        repository.put(fullName, newEmployee);
        return newEmployee;
    }

    public Employee addEmployee(String firstName, String middleName, String lastName, int department, int salary)
    {
        firstName = validateName(firstName);
        middleName = validateName(middleName);
        lastName = validateName(lastName);
        String fullName = firstName + ' ' + middleName + ' ' + lastName;

        if (repository.containsKey(fullName))
            throw new EmployeeAlreadyAddedException();

        Employee newEmployee = new Employee(firstName, middleName, lastName, department ,salary);
        newEmployee.setId(repository.size());
        repository.put(fullName, newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName)
    {
        firstName = validateName(firstName);
        lastName = validateName(lastName);
        String fullName = firstName + ' ' + lastName;

        if (repository.containsKey(fullName))
        {
            Employee employee = repository.get(fullName);
            repository.remove(fullName);
            return employee;
        }
        else
            throw new IllegalArgumentException("No employee with name " + fullName);
    }

    public Employee removeEmployee(int id)
    {
        Employee employee = null;
        String fullName = null;
        for (Employee e: repository.values())
        {
            if (e.getId() == id)
            {
                employee = e;
                fullName = e.getFullName();
                break;
            }
        }
        if (fullName != null)
        {
            repository.remove(fullName);
            return employee;
        }
        else
            throw new IllegalArgumentException("No employee with ID " + id);
    }

    public Employee findEmployee(String firstName, String lastName)
    {
        firstName = validateName(firstName);
        lastName = validateName(lastName);
        String fullName = firstName + ' ' + lastName;
        if (repository.containsKey(fullName))
            return repository.get(fullName);

        throw new EmployeeNotFoundException();
    }

    public void modifyEmployeeData(String firstName, String middleName, String lastName, int newDepartment, int newSalary)
    {
        firstName = validateName(firstName);
        middleName = validateName(middleName);
        lastName = validateName(lastName);
        String fullName = firstName + ' ' + middleName + ' ' + lastName;

        if (repository.containsKey(fullName))
        {
            Employee employee = repository.get(fullName);
            employee.setDepartment(newDepartment);
            employee.setSalary(newSalary);
        }
        else
            throw new IllegalArgumentException("No employee with name " + fullName);
    }

    public List<Employee> getEmployees()
    {
        if (repository.keySet().isEmpty())
        {
            System.out.println("employees repo is empty ");
            throw new EmployeeNotFoundException();
        }

        return repository.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public int getMonthlySalaryTotal()
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        return repository.values().stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);
    }

    public int getLowestSalary()
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        Stream stream = repository.values().stream()
                .sorted(Comparator.comparingInt(Employee::getSalary));

        Optional<Employee> employeeOptional =  stream.findFirst();
        Employee employee = employeeOptional.get();
        return employee.getSalary();
//        System.out.println(employee.getFullName() + " is on the lowest monthly salary of " + employee.getSalary());
    }

    public int getHighestSalary()
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> list = repository.values().stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        Employee employee = list.get(list.size() -1);
        return employee.getSalary();
//        System.out.println(employee.getFullName() + " is on the highest monthly salary of " + employee.getSalary());
    }

    public int getAverageSalary()
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        int total = repository.values().stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

//        System.out.println("Average monthly salary is " + total/ Employee.count);
        return total / repository.size();
    }

    public void printEmployeesNames()
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        repository.values().stream()
                .forEach(e -> System.out.println(e.getFullName()));
    }

    public void changeSalary(float percent)
    {
        for (Map.Entry<String, Employee> entry : repository.entrySet())
        {
            Employee employee = entry.getValue();
            if (employee == null)
                continue;

            int newSalary = (int)(employee.getSalary() * percent * .01f);
            employee.setSalary(newSalary);
        }
    }

    public Employee getEmployeeWithLowestSalaryInDepartment(int department)
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employees = repository.values().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        if (employees.isEmpty())
            throw new RuntimeException("No employees in department " + department);

        return employees.get(0);
//        System.out.println(employee.getFullName() + " from " + department + " department is on the lowest monthly salary of " + employee.getSalary());
    }

    public void printSalaryTotalInDepartment(int department)
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        int total = repository.values().stream()
                .filter(e -> e.getDepartment() == department)
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        System.out.println("Total monthly salary in " + department + " department is " + total);
    }

    public void printAverageSalaryInDepartment(int department)
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employeesInDepartment = repository.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        int total = employeesInDepartment.stream()
                .map(e -> e.getSalary())
                .reduce(0, (Integer a, Integer b) -> a + b);

        float average = total / employeesInDepartment.size();
        System.out.println("Average monthly salary in department " + department + " is " + average);
    }

    public void changeSalaryInDepartment(float percent, int department)
    {
        for (Map.Entry<String, Employee> entry : repository.entrySet())
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
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employeesInDepartment = repository.values().stream()
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

    public void printEmployeesWithSalaryLowerThan(int salary)
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employeesWithLowSalary = repository.values().stream()
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

    public void printEmployeesWithSalaryHigherThan(int salary)
    {
        if (repository.keySet().isEmpty())
            throw new EmployeeNotFoundException();

        List<Employee> employeesWithHighSalary = repository.values().stream()
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
