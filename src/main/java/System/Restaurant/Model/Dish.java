package System.Restaurant.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
    public Dish(
            String name,
            boolean vegetarian,
            int calories,
            Type type
    ){
        this.name=name;
        this.vegetarian=vegetarian;
        this.calories=calories;
        this.type=type;
    }
    public enum Type {MEAT, VEGETABLES, FRUITS, SEA_FOOD}
}
