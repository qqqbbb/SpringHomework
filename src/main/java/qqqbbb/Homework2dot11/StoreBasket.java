package qqqbbb.Homework2dot11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope

public class StoreBasket
{
//    @Autowired
    public StoreBasket()
    {
        System.out.println("StoreBasket created");
    }
    private List<Integer> itemIDs = new ArrayList<>();

    public List<Integer> getItems()
    {
        return itemIDs;
    }

    public void addItems(List<Integer> itemIDs)
    {
        this.itemIDs.addAll(itemIDs);
    }
}
