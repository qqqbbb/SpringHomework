package qqqbbb.Homework2dot11;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class StoreBasket
{
    public List<Integer> itemIDs = new ArrayList<>();

}
