package qqqbbb.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class Main
{
//    static HashMap<Integer, Student> m = new HashMap<Integer, Student>();
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
//        m.put(1, new Student(1L, "name!", 11));
//        Student student = m.get(1);
//        System.out.println(student.getName());
//        m.remove(1);
//        System.out.println("size " + m.size());
//        System.out.println(student.getName());
//        StudentController studentController = new StudentController(new StudentService());
//        StudentService studentService = new StudentService();
//        List<Student> students = studentService.getAllStudents().stream().filter(s -> s.getAge() == 1).collect(Collectors.toList());
//        System.out.println(students.size());;
    }
}

