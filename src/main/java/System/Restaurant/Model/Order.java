package System.Restaurant.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(targetEntity=Dish.class)
    @Size(min=1, message="You must choose at least 1 dish")
    private List<Dish> dishes;
    @CreatedDate
    private Date created;

    private int price;

}
