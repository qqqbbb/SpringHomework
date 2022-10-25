package qqqbbb.hogwarts.school.model;

import java.util.Objects;

public class House
{
    private long id;
    private String name;
    private String color;

    public House(long id, String name, String color)
    {
        this.id = id;
        this.name = name;
        this.color = color;
    }

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
