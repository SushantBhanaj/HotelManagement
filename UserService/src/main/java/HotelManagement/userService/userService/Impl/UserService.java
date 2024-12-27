package HotelManagement.userService.userService.Impl;

import HotelManagement.userService.userEntity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
