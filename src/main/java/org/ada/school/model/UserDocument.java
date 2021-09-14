package org.ada.school.model;

import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    public UserDocument()
    {
        this.createdAt =  new Date();
    }

    public UserDocument(User user){
        setId(user.getId());
        setCreatedAt(user.getCreatedAt());
        setEmail(user.getEmail());
        setName(user.getName());
        setLastName(user.getLastName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserDocument updateData(UserDto userDto){
        this.setLastName(userDto.getLastName());
        this.setName(userDto.getName());
        this.setEmail(userDto.getEmail());
        return this;
    }
}