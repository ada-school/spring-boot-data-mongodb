package org.ada.school.model;

import org.ada.school.dto.UserDto;

import java.util.Date;
import java.util.UUID;

/**
 * The type User.
 */
public class User

{

    private String id;

    private String name;

    private String email;

    private String lastName;

    private Date createdAt;


    /**
     * Instantiates a new User.
     *
     * @param userDto the user dto
     */
    public User( UserDto userDto )
    {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
    }

    /**
     * Instantiates a new User.
     *
     * @param userDocument the user document
     */
    public User(UserDocument userDocument){

        this.id  = userDocument.getId();
        this.name = userDocument.getName();
        this.lastName = userDocument.getLastName();
        this.email = userDocument.getEmail();
        this.createdAt = userDocument.getCreatedAt();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Update.
     *
     * @param userDto the user dto
     */
    public void update(UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
