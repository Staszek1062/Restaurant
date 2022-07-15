package System.Restaurant.Model;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private List<Dish> order;
    private LocalDate created;
    private int orderPrice;
}
