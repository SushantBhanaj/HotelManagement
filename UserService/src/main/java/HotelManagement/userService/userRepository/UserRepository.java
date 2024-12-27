package HotelManagement.userService.userRepository;

import HotelManagement.userService.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
