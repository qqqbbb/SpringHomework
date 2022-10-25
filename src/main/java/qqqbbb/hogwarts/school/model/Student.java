package qqqbbb.hogwarts.school.model;

import java.util.Objects;

public class Student
{
    private long id;
    private String name;
    private int age;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getId() == student.getId() && getName().equals(student.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getName(), getAge());
    }

    public Student(long id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

}
