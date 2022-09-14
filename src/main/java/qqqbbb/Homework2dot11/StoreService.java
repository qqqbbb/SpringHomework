package qqqbbb.Homework2dot11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService
{

    private StoreBasket storeBasket;

    public StoreService(StoreBasket storeBasket)
    {
        this.storeBasket = storeBasket;
    }
    public String addItems(List<Integer> idList)
    {
        if (storeBasket == null)
            return "storeBasket == null " ;

        storeBasket.addItems(idList);
        return "Added to basket: " + idList;
    }

    public String getStoreOrder()
    {
        return "Items in basket: " + storeBasket.getItems().toString();
    }
}
