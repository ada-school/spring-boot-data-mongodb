package org.ada.school.repository;

import lombok.Getter;
import org.ada.school.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
public class UserDocument {
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

    public UserDocument(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        lastName = user.getLastName();
        createdAt = user.getCreatedAt();
    }
}
