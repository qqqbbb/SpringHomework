package qqqbbb.Homework2dot11;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService
{
    StoreBasket storeBasket;

    public String addItem(List<Integer> idList)
    {
//        if (storeBasket == null)
//            return "storeBasket == null ";
        storeBasket.itemIDs.addAll(idList);
        return "Added to basket: " + idList;
    }

    public String getStoreOrder()
    {
        return "Items in basket: " + storeBasket.itemIDs.toString();
    }
}
