package org.ada.school.model;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@NoArgsConstructor
public class User {

	@Id
    String id;

    String name;

	@Indexed(unique = true)
	String email;

	String lastName;

    Date createdAt;

    public User(UserDto userDto) {

        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public void update(UserDto userDto) {

        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
