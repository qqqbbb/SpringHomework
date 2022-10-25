package qqqbbb.hogwarts.school.service;

import org.springframework.stereotype.Service;
import qqqbbb.hogwarts.school.model.House;
import java.util.*;

@Service
public class HouseService
{
    private Map<Long, House> houses = new HashMap<>();
    private long count = 0;

    public House addHouse(House house)
    {
        if (houses.containsValue(house))
            return null;

        houses.put(house.getId(), house);
        count++;
        return house;
    }

    public House getHouse(long id)
    {
        return houses.get(id);
    }

    public House editHouse(House house)
    {
        if (!houses.containsKey(house.getId()))
            return null;

        houses.put(house.getId(), house);
        return house;
    }

    public House deleteHouse(long id)
    {
        House house = houses.get(id);
        if (houses.containsKey(id))
        {
            houses.remove(id);
            count--;
        }
        return house;
    }

    public Collection<House> getAllHouses()
    {
        return new ArrayList<>(houses.values());
    }
}
