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

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(@Qualifier("userServiceMongoDB") UserService userService) {

		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> all() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.all());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(new User(userDto)));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto, id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/NameOrLastname/{nameOrLastname}")
	public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike(@PathVariable String nameOrLastname) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNameOrLastNameLike(nameOrLastname));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/createdAfter/{createdAfter}")
	public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdAfter) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersCreatedAfter(createdAfter));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
