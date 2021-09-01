package org.ada.school.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Define the signature to implement a {@link UserService} using a Hashmap
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("userServiceHashMap")
public class UserServiceHashMap implements UserService {

	/**
	 * The HashMap were the users are saved
	 */
	private final HashMap<String, User> usersMap = new HashMap<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User create(final User user) {

		usersMap.put(user.getId(), user);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(final String id) {

		if (usersMap.containsKey(id)) {
			return usersMap.get(id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> all() {

		return new ArrayList<>(usersMap.values());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteById(String id) {

		return usersMap.remove(id) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User update(final UserDto userDto, final String id) {

		if (usersMap.containsKey(id)) {
			User user = usersMap.get(id);
			user.update(userDto);
			return user;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsersWithNameOrLastNameLike(final String queryText) {

		List<User> users = new ArrayList<>();

		for (User user : usersMap.values()) {
			if (user.getName().equals(queryText) || user.getLastName().equals(queryText)) {
				users.add(user);
			}
		}

		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findUsersCreatedAfter(final Date startDate) {

		List<User> users = new ArrayList<>();

		for (User user : usersMap.values()) {
			if (user.getCreatedAt().after(startDate)) {
				users.add(user);
			}
		}

		return users;
	}

}
