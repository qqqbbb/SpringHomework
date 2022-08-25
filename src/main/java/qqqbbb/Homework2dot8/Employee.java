package qqqbbb.Homework2dot8;

import java.util.Objects;

public class Employee
{
    String firstName;
    String middleName;
    String lastName;
    int department;
    int salary;
    int id;
    static int count;

    public Employee(String firstName, String middleName, String lastName, int department, int salary)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = count;
//        count++;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && firstName.equals(employee.firstName) && middleName.equals(employee.middleName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString()
    {
        return getFullName() + ", id " + getId() + ", department " + getDepartment() + ", salary " + getSalary();
    }

    public String getFullName()
    {
        return getFirstName() + ' ' + getMiddleName() + ' ' + getLastName();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getDepartment()
    {
        return department;
    }

    public int getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

    public static int getCount()
    {
        return count;
    }

    public void setDepartment(int department)
    {
        this.department = department;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}
