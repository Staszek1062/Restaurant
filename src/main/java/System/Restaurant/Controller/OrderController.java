package System.Restaurant.Controller;

import System.Restaurant.Model.Order;

import System.Restaurant.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
 public static final Long EMPTY_ID = null;
 private final OrderService orderService;

 @GetMapping
 public CollectionModel<EntityModel<Order>> getOrders(){

  List<EntityModel<Order>> orders= orderService.getOrders().stream()
      .map(order -> EntityModel.of(order,
          linkTo(methodOn(OrderController.class).getOrder(order.getId())).withSelfRel(),
          linkTo(methodOn(OrderController.class).getOrders()).withRel("orders")
      )).toList();
  return CollectionModel.of(orders,
      linkTo(methodOn(OrderController.class).getOrders()).withSelfRel()
  );
 }
 @GetMapping("/{id}")
 public EntityModel<Order> getOrder(@PathVariable Long id){
  return EntityModel.of(orderService.getOrder(id),
      linkTo(methodOn(OrderController.class).getOrder(id)).withSelfRel(),
      linkTo(methodOn(OrderController.class).getOrders()).withRel("Orders"),
      linkTo(OrderController.class).slash("employees").slash(id).slash("deactivate")
          .withRel("deactivate")
  );
 }

 @PostMapping
 public Order createDishes(@RequestBody Order orderDto){
  return orderService.createOrder(new Order(
          EMPTY_ID,
          orderDto.getDishes(),
          orderDto.getCreated(),
          orderDto.getPrice()
      )
  );
 }
 @PutMapping("/{id}")
 public ResponseEntity<Object> updateDish(@PathVariable Long id, @RequestBody Order orderDto){
  orderService.updateOrder(new Order(
          id,
          orderDto.getDishes(),
          orderDto.getCreated(),
          orderDto.getPrice()
      )
  );
  return ResponseEntity.noContent().build();
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Object> deleteDish(@PathVariable Long id){
  orderService.deleteOrder(id);
  return ResponseEntity.noContent().build();
 }
}
