package org.ada.school.repository;
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

    public UserDocument(String id, String name, String email, String lastName, Date createdAt) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.createdAt=createdAt;
    }
}
