package qqqbbb.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqqbbb.hogwarts.school.model.*;
import qqqbbb.hogwarts.school.service.StudentService;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("student")
@RestController
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student studentToAdd)
    {
        Student student = studentService.addStudent(studentToAdd);
        if (student == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(student);
    }

    @GetMapping("{id}")
    public ResponseEntity getStudent(@PathVariable long id)
    {
        Student student = studentService.getStudent(id);

        if (student == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity editStudent(@RequestBody Student StudentToEdit)
    {
        Student student = studentService.editStudent(StudentToEdit);
        if (student == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id)
    {
        Student student = studentService.deleteStudent(id);
        if (student == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(student);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getStudentsByAge(@PathVariable long age)
    {
        List<Student> students = studentService.getAllStudents().stream().filter(s -> s.getAge() == age).collect(Collectors.toList());
        return ResponseEntity.ok(students);
    }

    @GetMapping("all")
    public ResponseEntity getAllStudents()
    {
        Collection<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
