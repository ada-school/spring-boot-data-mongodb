package org.ada.school.repository;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
public class UserDocument

{
    @Id
    String id;

    String name;

    @Indexed( unique = true )
    String email;

    String lastName;

    Date createdAt;

    public UserDocument()
    {
    }
    public UserDocument(User user){
        this.id = user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.lastName=user.getLastName();
        this.createdAt=user.getCreatedAt();

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void updateUserDocument(UserDto userDto){
        this.name=userDto.getName();
        this.email=userDto.getEmail();
        this.lastName=userDto.getLastName();
    }
}

