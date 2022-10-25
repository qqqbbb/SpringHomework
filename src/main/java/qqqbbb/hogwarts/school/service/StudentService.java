package qqqbbb.hogwarts.school.service;

import org.springframework.stereotype.Service;
import qqqbbb.hogwarts.school.model.Student;
import java.util.*;

@Service
public class StudentService
{
    private Map<Long, Student> students = new HashMap<>();
    private long count = 0;

    public Student addStudent(Student student)
    {
        if (students.containsValue(student))
            return null;

        students.put(student.getId(), student);
        count++;
        return student;
    }

    public Student getStudent(long id)
    {
        return students.get(id);
    }

    public Student editStudent(Student student)
    {
        if (!students.containsKey(student.getId()))
            return null;

        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id)
    {
        Student student = students.get(id); // not null after remove
        if (students.containsKey(id))
        {
            students.remove(id);
            count--;
        }
        return student;
    }

    public Collection<Student> getAllStudents()
    {
        return new ArrayList<>(students.values());
    }
}
