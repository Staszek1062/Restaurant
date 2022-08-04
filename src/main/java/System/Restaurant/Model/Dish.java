package System.Restaurant.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=3,max=50)
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
