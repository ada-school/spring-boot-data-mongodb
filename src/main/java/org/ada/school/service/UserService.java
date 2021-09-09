package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.exception.UserException;
import org.ada.school.model.User;

import java.util.List;

public interface UserService
{
    User create( User user ) throws UserException;
    User create( UserDto user ) throws UserException;
    User findById( String id ) throws UserException;

    List<User> all();

    boolean deleteById( String id ) throws UserException;

    User update( UserDto userDto, String id ) throws UserException;
}
