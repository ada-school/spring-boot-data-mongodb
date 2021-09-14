package org.ada.school.model;

import org.ada.school.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class User

{

    private String id;

    private String name;

    private String email;

    private String lastName;

    private Date createdAt;


    public User( UserDto userDto )
    {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
    }

    public User(UserDocument userDocument){

        this.id  = userDocument.getId();
        this.name = userDocument.getName();
        this.lastName = userDocument.getLastName();
        this.email = userDocument.getEmail();
        this.createdAt = userDocument.getCreatedAt();
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void update(UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
