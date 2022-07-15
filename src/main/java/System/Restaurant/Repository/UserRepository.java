package System.Restaurant.Repository;

import System.Restaurant.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
