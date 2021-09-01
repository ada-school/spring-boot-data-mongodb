package org.ada.school.exception;

/**
 * The exception to be thrown when an error is present in the UserService
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserServiceException extends Exception {

	/**
	 * User Not Found Message
	 */
	public static final String USER_NOT_FOUND = "User not found";

	/**
	 * Constructor
	 *
	 * @param message Message of the Exception
	 */
	public UserServiceException(final String message) {

		super(message);
	}

}
