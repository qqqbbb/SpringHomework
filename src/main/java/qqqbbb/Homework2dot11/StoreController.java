package qqqbbb.Homework2dot11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")
public class StoreController
{
    private final StoreService storeService;

    public StoreController(StoreService storeService)
    {
        this.storeService = storeService;
        this.storeService.storeBasket = new StoreBasket();
    }

    @GetMapping(path="/add")
    public String addItem(@RequestParam List<Integer> id)
    {
        return storeService.addItem(id);
    }

    @GetMapping(path="/get")
    public String getStoreOrder()
    {
        return storeService.getStoreOrder();
    }
}
