package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserService
{
    UserDocument create( UserDocument user );

    UserDocument findById( String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    UserDocument update( UserDto userDto, String id );

}
