package org.ada.school.model;

import java.util.Date;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import org.ada.school.dto.UserDto;

@Getter()
public class User {

    String id;

    String name;

	@Getter(AccessLevel.NONE)
    String email;

	@Getter(AccessLevel.NONE)
    String lastName;

	@Getter(AccessLevel.NONE)
    Date createdAt;


    public User( UserDto userDto ) {

        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }


    public void update( UserDto userDto ) {

        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
