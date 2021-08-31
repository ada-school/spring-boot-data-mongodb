package edu.eci.userapi.service;

import edu.eci.userapi.data.dto.UserDto;
import edu.eci.userapi.data.document.User;

import java.util.List;

public interface UserService
{
    User create(User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update(UserDto userDto, String id );
}
