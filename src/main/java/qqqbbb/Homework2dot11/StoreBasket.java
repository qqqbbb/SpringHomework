package qqqbbb.Homework2dot11;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class StoreBasket
{
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
