package System.Restaurant.Controller;

import System.Restaurant.Model.Dish;
import System.Restaurant.Model.DishDto;
import System.Restaurant.Services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    public static final Long EMPTY_ID = null;
    private final RestaurantService restaurantService;
    @GetMapping("/dishes")
    public List<Dish> getDishes(){
        return restaurantService.getDishes();
    }
    @GetMapping("/dishes/{id}")
    public  Dish getDish(@PathVariable Long id){
        return restaurantService.getDish(id);
    }
    @PostMapping("/dishes")
    public Dish createDishes(@RequestBody DishDto dishDto){
        return restaurantService.createDish(new Dish(
                EMPTY_ID,
                dishDto.getName(),
                dishDto.isVegetarian(),
                dishDto.getCalories(),
                dishDto.getCreated()
                )
        );
    }
    @PutMapping("/dishes/{id}")
    public ResponseEntity<Object> updateDish(@PathVariable Long id,@RequestBody DishDto dishDto){
        restaurantService.updateDish(new Dish(
                id,
                dishDto.getName(),
                dishDto.isVegetarian(),
                dishDto.getCalories(),
                dishDto.getCreated()
                )
        );
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<Object> deleteDish(@PathVariable Long id){
        restaurantService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }


}
