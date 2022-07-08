package System.Restaurant.Services;

import System.Restaurant.Model.Dish;
import System.Restaurant.Repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    DishRepository restaurantRepository;

    public List<Dish> getDishes() { return restaurantRepository.findAll();}
    public Dish getDish(Long id) { return restaurantRepository.findById(id).orElseThrow();}
    public Dish createDish(Dish dish) {return restaurantRepository.save(dish);}

    public Dish updateDish(Dish dish) {return restaurantRepository.save(dish);
    }

    public void deleteDish(Long id) {
    }


}
