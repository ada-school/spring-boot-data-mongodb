package org.ada.school.model;


import lombok.Getter;
import org.ada.school.dto.UserDto;
import org.ada.school.repository.UserDocument;

import java.util.Date;
import java.util.UUID;

@Getter
public class User

{

    String id;

    String name;

    String email;

    String lastName;

    Date createdAt;

    public User(UserDocument userDocument) {
        id = userDocument.getId();
        name = userDocument.getName();
        email = userDocument.getEmail();
        lastName = userDocument.getLastName();
        createdAt = userDocument.getCreatedAt();
    }


    public User( UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
