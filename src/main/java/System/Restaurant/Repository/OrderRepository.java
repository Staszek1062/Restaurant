package System.Restaurant.Repository;

import System.Restaurant.Model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

 List<Order> findAll();
}
