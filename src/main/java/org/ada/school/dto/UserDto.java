package org.ada.school.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapping class for the User class
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class UserDto {

	/**
	 * The name of the user
	 */
	String name;

	/**
	 * The email of the user
	 */
	String email;

	/**
	 * The lastName of the user
	 */
	String lastName;

}
