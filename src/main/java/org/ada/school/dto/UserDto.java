package org.ada.school.dto;

import lombok.Setter;

@Setter
public class UserDto
{
    String name;

    String email;

    String lastName;

    public UserDto()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }
}
