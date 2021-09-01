package org.ada.school.service;

import java.util.Date;
import java.util.List;

import org.ada.school.dto.UserDto;
import org.ada.school.exception.UserServiceException;
import org.ada.school.model.User;
import org.springframework.stereotype.Service;

/**
 * Define the signature to implement a User Service
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface UserService {

	/**
	 * Create a user
	 *
	 * @param user The {@link User} to be created in the records
	 * @return The user that is now in the records
	 */
	User create(User user);

	/**
	 * Find a User that is in the records
	 *
	 * @param id The user id to be found
	 * @return The {@link User} that has been found
	 * @throws UserServiceException The {@link UserServiceException}
	 */
	User findById(String id) throws UserServiceException;

	/**
	 * Find all the users in the records
	 *
	 * @return All the users in the records
	 */
	List<User> all();

	/**
	 * Delete a user given the User Id
	 *
	 * @param id The id of the {@link User} to be deleted
	 * @return If the operation could be performed
	 */
	boolean deleteById(String id);

	/**
	 * Update a user if given the User id
	 *
	 * @param user The {@link User} with the new information
	 * @param id   The id of the {@link User} to be Updated
	 * @return The {@link User} that has been Updated
	 * @throws UserServiceException The {@link UserServiceException}
	 */
	User update(UserDto userDto, String id) throws UserServiceException;

	/**
	 * Find the users that his name or lastname contains a certain string of characters
	 *
	 * @param queryText The string of characters
	 * @return The List of the users that his name or lastname are like the string of characters
	 */
	List<User> findUsersWithNameOrLastNameLike(String queryText);

	/**
	 * Find the user that have been created after a certain date
	 *
	 * @param startDate The starDate used to find the users
	 * @return List of users created after the given date
	 */
	List<User> findUsersCreatedAfter(Date startDate);
}
