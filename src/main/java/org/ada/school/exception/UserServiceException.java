package org.ada.school.exception;

public class UserServiceException extends Exception {

	public static final String USER_NOT_FOUND = "User not found";

	public UserServiceException(final String message) {

		super(message);
	}

}
