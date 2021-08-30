package edu.eci.userapi.service;

import edu.eci.userapi.dto.UserDto;
import edu.eci.userapi.model.User;

import java.util.List;

public interface UserService
{
    User create(User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update(UserDto userDto, String id );
}
