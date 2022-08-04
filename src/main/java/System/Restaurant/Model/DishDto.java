package System.Restaurant.Model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
public class DishDto {
    @NotNull
    @Size(min=3,max=50)
    private String name;
    private boolean vegetarian;
    private int calories;
    private Dish.Type type;


}
