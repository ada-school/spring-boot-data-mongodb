package org.ada.school.model;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User class - That is used as Document for MongoDB
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Document
@NoArgsConstructor
public class User {

	/**
	 * The user identifier
	 */
	@Id
    String id;

	/**
	 * The name of the user
	 */
    String name;

	/**
	 * The user email
	 */
	@Indexed(unique = true)
	String email;

	/**
	 * The user lastname
	 */
	String lastName;

	/**
	 * The date of creation of the user
	 */
    Date createdAt;

	/**
	 * Constructor used to map a UserDto to a User class
	 *
	 * @param userDto The {@link UserDto} to be mapped
	 */
    public User(UserDto userDto) {

        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

	/**
	 * Update the information of the user
	 *
	 * @param userDto The {@link UserDto} that contains the new information
	 */
    public void update(UserDto userDto) {

        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
