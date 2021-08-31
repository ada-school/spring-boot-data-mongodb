package edu.eci.userapi.service;

import edu.eci.userapi.data.document.User;
import edu.eci.userapi.data.dto.UserDto;
import edu.eci.userapi.data.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceMongoDB implements UserService{

    private final UserRespository userRespository;

    public UserServiceMongoDB(@Autowired UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        return null;
    }
}
