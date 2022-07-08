package System.Restaurant.Services;

import System.Restaurant.Model.Dish;
import System.Restaurant.Repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final DishRepository dishRepository;
    public List<Dish> getDishes() { return dishRepository.findAll();}
    public Dish getDish(Long id) { return dishRepository.findById(id).orElseThrow();}
    public Dish createDish(Dish dish) {return dishRepository.save(dish);}
    public Dish updateDish(Dish dish) {return dishRepository.save(dish);}
    public void deleteDish(Long id) { dishRepository.deleteById(id);}


}
