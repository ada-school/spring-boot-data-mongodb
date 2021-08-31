package edu.eci.userapi.service;

import edu.eci.userapi.data.dto.UserDto;
import edu.eci.userapi.data.repository.UserDocument;

import java.util.List;

public interface UserService
{
    UserDocument create(UserDocument user );

    UserDocument findById( String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    UserDocument update(UserDto userDto, String id );
}
