package org.ada.school.model;

import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * The type User document.
 */
@Document
public class UserDocument
{
    @Id
    private String id;

    private String name;

    @Indexed( unique = true )
    private String email;

    private String lastName;

    private Date createdAt;

    /**
     * Instantiates a new User document.
     */
    public UserDocument()
    {
        this.createdAt =  new Date();
    }

    /**
     * Instantiates a new User document.
     *
     * @param user the user
     */
    public UserDocument(User user){
        setId(user.getId());
        setCreatedAt(user.getCreatedAt());
        setEmail(user.getEmail());
        setName(user.getName());
        setLastName(user.getLastName());
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Update data user document.
     *
     * @param userDto the user dto
     * @return the user document
     */
    public UserDocument updateData(UserDto userDto){
        this.setLastName(userDto.getLastName());
        this.setName(userDto.getName());
        this.setEmail(userDto.getEmail());
        return this;
    }
}