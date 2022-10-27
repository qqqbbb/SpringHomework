package qqqbbb.hogwarts.school.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class House
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String color;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return getId() == house.getId() && getName().equals(house.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getName());
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }
}
