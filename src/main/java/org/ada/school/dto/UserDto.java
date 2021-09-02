package org.ada.school.dto;

public class UserDto
{
    String name;

    String email;

    String lastName;


    public UserDto(String email, String name, String lastName) {
        this.email=email;
        this.name=name;
        this.lastName=lastName;
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
