package edu.eci.userapi.service;

import edu.eci.userapi.data.document.User;
import edu.eci.userapi.data.dto.UserDto;
import edu.eci.userapi.data.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRespository userRespository;

    public UserServiceMongoDB(@Autowired UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User create(User user) {
        return userRespository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRespository.findById(id).orElse(null);
    }

    @Override
    public List<User> all() {
        return userRespository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if(userRespository.existsById(id)){
            userRespository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        User oldUser = userRespository.findById(id).orElse(null);
        oldUser.update(userDto);
        userRespository.save(oldUser);
        return oldUser;
    }
}