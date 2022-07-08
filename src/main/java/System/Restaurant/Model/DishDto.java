package System.Restaurant.Model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DishDto {
    private Long id;
    private String name;
    private boolean vegetarian;
    private int calories;
    private Dish.Type type;
    private LocalDate created;
    public enum Type{MEAT,VEGETABLES,FRUITS,SEA_FOOD}
}
