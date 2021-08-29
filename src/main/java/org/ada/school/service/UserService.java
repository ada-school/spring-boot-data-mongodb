package org.ada.school.service;

import java.util.Date;
import java.util.List;

import org.ada.school.dto.UserDto;
import org.ada.school.exception.UserServiceException;
import org.ada.school.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	User create(User user);

	User findById(String id) throws UserServiceException;

	List<User> all();

	boolean deleteById(String id);

	User update(UserDto userDto, String id) throws UserServiceException;

	List<User> findUsersWithNameOrLastNameLike(String queryText);

	List<User> findUsersCreatedAfter(Date startDate);
}
