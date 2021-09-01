package org.ada.school.controller;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller class
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

	/**
	 * The {@link UserService}
	 */
	private final UserService userService;

	/**
	 * Constructor
	 *
	 * @param userService The {@link UserService}
	 */
	@Autowired
	public UserController(@Qualifier("userServiceMongoDB") UserService userService) {

		this.userService = userService;
	}

	/**
	 * Get All endpoint
	 *
	 * @return List of the {@link User} saved in the server
	 */
	@GetMapping
	public ResponseEntity<List<User>> all() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.all());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Get findById endpoint
	 *
	 * @param id The id of the {@link User} to be found
	 * @return The {@link User} found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/**
	 * Post create endpoint
	 *
	 * @param userDto The {@link UserDto} to be saved
	 * @return The {@link User} saved in the server
	 */
	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(new User(userDto)));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Put update endpoint
	 *
	 * @param userDto The {@link UserDto} to be updated
	 * @param id      The {@link User} id to be updated
	 * @return The {@link User} after being updated
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto, id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Delete delete endpoint
	 *
	 * @param id The {@link User} id to be deleted
	 * @return If the {@link User} has been deleted
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Find Users With Name Or LastName Like endpoint
	 *
	 * @param nameOrLastname Name or Lastname of the {@link User}
	 * @return The {@link User} list found in the server
	 */
	@GetMapping("/NameOrLastname/{nameOrLastname}")
	public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike(@PathVariable String nameOrLastname) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNameOrLastNameLike(nameOrLastname));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Find Users Created After endpoint
	 *
	 * @param createdAfter Minimum date of creation the Users
	 * @return The {@link User} list found in the server
	 */
	@GetMapping("/createdAfter/{createdAfter}")
	public ResponseEntity<List<User>> findUsersCreatedAfter(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdAfter) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersCreatedAfter(createdAfter));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
