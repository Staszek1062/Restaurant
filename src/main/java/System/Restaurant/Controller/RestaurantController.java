package System.Restaurant.Controller;

import System.Restaurant.Model.Dish;
import System.Restaurant.Model.DishDto;
import System.Restaurant.Services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    public static final Long EMPTY_ID = null;
    private final RestaurantService restaurantService;
    @GetMapping("/dishes")
    public CollectionModel<EntityModel<Dish>> getDishes(){

        List<EntityModel<Dish>> dishes=restaurantService.getDishes().stream()
                .map(dish -> EntityModel.of(dish,
                        linkTo(methodOn(RestaurantController.class).getDish(dish.getId())).withSelfRel(),
                        linkTo(methodOn(RestaurantController.class).getDishes()).withRel("dishes")
                        )).toList();
        return CollectionModel.of(dishes,
                linkTo(methodOn(RestaurantController.class).getDishes()).withSelfRel()
        );
    }
    @GetMapping("/dishes/{id}")
    public EntityModel<Dish> getDish(@PathVariable Long id){
        return EntityModel.of(restaurantService.getDish(id),
                linkTo(methodOn(RestaurantController.class).getDish(id)).withSelfRel(),
                linkTo(methodOn(RestaurantController.class).getDishes()).withRel("dishes"),
                linkTo(RestaurantController.class).slash("employees").slash(id).slash("deactivate")
                        .withRel("deactivate")
        );
    }
    @PostMapping("/dishes")
    public Dish createDishes(@RequestBody DishDto dishDto){
        return restaurantService.createDish(new Dish(
                EMPTY_ID,
                dishDto.getName(),
                dishDto.isVegetarian(),
                dishDto.getCalories(),
                dishDto.getType()
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
                dishDto.getType()
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
