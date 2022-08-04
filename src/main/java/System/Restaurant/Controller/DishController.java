package System.Restaurant.Controller;

import System.Restaurant.Model.Dish;
import System.Restaurant.Model.DishDto;
import System.Restaurant.Services.DishService;
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
public class DishController {
    public static final Long EMPTY_ID = null;
    private final DishService dishService;
    @GetMapping("/dishes")
    public CollectionModel<EntityModel<Dish>> getDishes(){

        List<EntityModel<Dish>> dishes= dishService.getDishes().stream()
                .map(dish -> EntityModel.of(dish,
                        linkTo(methodOn(DishController.class).getDish(dish.getId())).withSelfRel(),
                        linkTo(methodOn(DishController.class).getDishes()).withRel("dishes")
                        )).toList();
        return CollectionModel.of(dishes,
                linkTo(methodOn(DishController.class).getDishes()).withSelfRel()
        );
    }
    @GetMapping("/dishes/{id}")
    public EntityModel<Dish> getDish(@PathVariable Long id){
        return EntityModel.of(dishService.getDish(id),
                linkTo(methodOn(DishController.class).getDish(id)).withSelfRel(),
                linkTo(methodOn(DishController.class).getDishes()).withRel("dishes"),
                linkTo(DishController.class).slash("employees").slash(id).slash("deactivate")
                        .withRel("deactivate")
        );
    }

    @PostMapping("/dishes")
    public Dish createDishes(@RequestBody DishDto dishDto){
        return dishService.createDish(new Dish(
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
        dishService.updateDish(new Dish(
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
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }


}
