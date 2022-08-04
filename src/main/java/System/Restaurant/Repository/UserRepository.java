package System.Restaurant.Repository;

import System.Restaurant.Model.Order;
import System.Restaurant.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
 List<User> findAll();
}
