package org.ada.school.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.ada.school.dto.UserDto;
import org.ada.school.exception.UserServiceException;
import org.ada.school.model.User;
import org.ada.school.repository.UserRepository;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceMongoDB implements UserService {

	private final UserRepository userRepository;

	@Override
	public User create(final User user) {

		return userRepository.save(user);
	}

	@Override
	public User findById(final String id) throws UserServiceException {

		Optional<User> userOptional = userRepository.findById(id);

		if (userOptional.isPresent()) {
			return userOptional.get();
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	@Override
	public List<User> all() {

		return userRepository.findAll();
	}

	@Override
	public boolean deleteById(final String id) {

		boolean couldBeDeleted = false;

		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			couldBeDeleted = true;
		}

		return couldBeDeleted;
	}

	@Override
	public User update(final UserDto userDto, final String id) throws UserServiceException {

		Optional<User> userOptional = userRepository.findById(id);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.update(userDto);
			userRepository.save(user);
			return user;
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	@Override
	public List<User> findUsersWithNameOrLastNameLike(final String queryText) {

		return userRepository.findByNameOrLastNameIsLike(queryText, queryText);
	}

	@Override
	public List<User> findUsersCreatedAfter(final Date startDate) {

		return userRepository.findByCreatedAtAfter(startDate);
	}
}
