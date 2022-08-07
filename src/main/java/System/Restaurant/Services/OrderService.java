package System.Restaurant.Services;


import System.Restaurant.Model.Order;
import System.Restaurant.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

 private final OrderRepository orderRepository;

 public List<Order> getOrders() { return orderRepository.findAll();}
 
 public Order getOrder(Long id) { return orderRepository.findById(id).orElseThrow();}
 public Order createOrder(Order order) {return orderRepository.save(order);}
 public Order updateOrder(Order order) {return orderRepository.save(order);}
 public void deleteOrder(Long id) { orderRepository.deleteById(id);}




}
