package System.Restaurant.Services;


import System.Restaurant.Model.User;
import System.Restaurant.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
 private final UserRepository userRepository;

 public List<User> getOrders() { return userRepository.findAll();}
 public User getUser(Long id) { return userRepository.findById(id).orElseThrow();}
 public User createUser(User user) {return userRepository.save(user);}
 public User updateUser(User user) {return userRepository.save(user);}
 public void deleteUser(Long id) { userRepository.deleteById(id);}
}
