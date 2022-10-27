package qqqbbb.Homework2dot8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(qqqbbb.Homework2dot8.Main.class, args);
        EmployeeBook.addNewEmployee("Andrey", "Andreyevich", "Andreyev", 3, 3311);
        EmployeeBook.addNewEmployee("Ivan", "Ivanovich", "Ivanov", 1, 1111);
        EmployeeBook.addNewEmployee("Sergey", "Sergeyevich", "Sergeyev", 2, 2211);
        EmployeeBook.addNewEmployee("Anton", "Antonovich", "Antonov", 1, 1122);
//        EmployeeBook.printEmployeesByDepartment();
//        EmployeeBook.printMonthlySalaryTotal();
//        EmployeeBook.printLowestSalary();
//        EmployeeBook.printHighestSalary();
//        EmployeeBook.printAverageSalary();
//        EmployeeBook.printEmployeesNames();
//        EmployeeBook.printLowestSalaryInDepartment(4);
//        EmployeeBook.printHighestSalaryInDepartment(1);
//        EmployeeBook.printSalaryTotalInDepartment(1);
//        EmployeeBook.printAverageSalaryInDepartment(1);
//        EmployeeBook.printEmployeesWithSalaryHigherThan(21111);


    }
}
