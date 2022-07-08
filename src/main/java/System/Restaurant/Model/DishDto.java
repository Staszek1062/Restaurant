package System.Restaurant.Model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DishDto {
    private String name;
    private boolean vegetarian;
    private int calories;
    private LocalDate created;
}
