package System.Restaurant.Controller;

import System.Restaurant.Model.Dish;
import System.Restaurant.Model.DishDto;
import System.Restaurant.Model.User;
import System.Restaurant.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
 public static final Long EMPTY_ID = null;
 private final UserService userService;

 @GetMapping
 public CollectionModel<EntityModel<User>> getUsers(){

  List<EntityModel<User>> users= userService.getUsers().stream()
      .map(user -> EntityModel.of(user,
          linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel(),
          linkTo(methodOn(UserController.class).getUsers()).withRel("users")
      )).toList();
  return CollectionModel.of(users,
      linkTo(methodOn(UserController.class).getUsers()).withSelfRel()
  );
 }
 @GetMapping("/{id}")
 public EntityModel<User> getUser(@PathVariable Long id){
  return EntityModel.of(userService.getUser(id),
      linkTo(methodOn(UserController.class).getUser(id)).withSelfRel(),
      linkTo(methodOn(UserController.class).getUsers()).withRel("users"),
      linkTo(UserController.class).slash("employees").slash(id).slash("deactivate")
          .withRel("deactivate")
  );
 }

 @PostMapping
 public User createUsers(@RequestBody User userDto){
  return userService.createUser(new User(
          EMPTY_ID,
    userDto.getUsername(),
    userDto.getPassword(),
    userDto.getEmail(),
    userDto.getFullname(),
    userDto.getStreet(),
    userDto.getCity(),
    userDto.getState(),
    userDto.getZip(),
    userDto.getPhoneNumber(),
    userDto.getCreated()
      )
  );
 }
 @PutMapping("/{id}")
 public ResponseEntity<Object> updateDish(@PathVariable Long id, @RequestBody User userDto){
  userService.updateUser(new User(
    id,
    userDto.getUsername(),
    userDto.getPassword(),
    userDto.getEmail(),
    userDto.getFullname(),
    userDto.getStreet(),
    userDto.getCity(),
    userDto.getState(),
    userDto.getZip(),
    userDto.getPhoneNumber(),
    userDto.getCreated()
      )
  );
  return ResponseEntity.noContent().build();
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Object> deleteDish(@PathVariable Long id){
  userService.deleteUser(id);
  return ResponseEntity.noContent().build();
 }
}
