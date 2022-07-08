package System.Restaurant.Controller;

import System.Restaurant.Model.Dish;
import System.Restaurant.Services.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    public static final Long EMPTY_ID = null;
    RestaurantService restaurantService;
    @GetMapping("/dishes")
    public List<Dish> getDishes(){
        return restaurantService.getDishes();
    }
    @GetMapping("/dishes/{id}")
    public  Dish getDish(@PathVariable Long id){
        return restaurantService.getDish(id);
    }
    @PostMapping("/dishes")
    public List<Dish> createDishes(){
        return restaurantService.createDish();
    }
    @PutMapping("/dishes/{id}")
    public ResponseEntity<Object> updateDish(@PathVariable Long id){
        restaurantService.updateDish();
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<Object> deleteDish(@PathVariable Long id){
        restaurantService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }


}
