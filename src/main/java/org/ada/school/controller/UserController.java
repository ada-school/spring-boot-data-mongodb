package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping( "/user" )
public class UserController
{

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    /**
     * All response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok( userService.all() );
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }

    /**
     * Find by name or lastname response entity.
     *
     * @param query the query
     * @return the response entity
     */
    @GetMapping( "/name/{query}" )
    public ResponseEntity<List<User>> findByNameOrLastname( @PathVariable String query)
    {
        return ResponseEntity.ok( userService.findUsersWithNameOrLastNameLike(query));
    }

    /**
     * Find by created at response entity.
     *
     * @param createdAt the created at
     * @return the response entity
     */
    @GetMapping( "/createdAt/{createdAt}" )
    public ResponseEntity<List<User>> findByCreatedAt( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdAt )
    {
        return ResponseEntity.ok( userService.findUsersCreatedAfter(createdAt));
    }


    /**
     * Create response entity.
     *
     * @param userDto the user dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( new User( userDto ) ) );
    }

    /**
     * Update response entity.
     *
     * @param userDto the user dto
     * @param id      the id
     * @return the response entity
     */
    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

}
