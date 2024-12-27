package HotelManagement.userService.UserController;

import HotelManagement.userService.userEntity.User;
import HotelManagement.userService.userService.Impl.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserService userService;

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User user1 = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user1);
        }

        @GetMapping("/{userId}")
         @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
        public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
            User user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        }
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        User user = new User();
        user.setUserId("141234");
        user.setName("Dummy");
        user.setEmail("dummy@gmail.com");
        user.setAbout("This user is created dummy because some service is down");
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
    @GetMapping
        public ResponseEntity<Object> getAllUser() {
            List<User> allUser = userService.getAllUser();
            return ResponseEntity.ok(allUser);
        }
    }
