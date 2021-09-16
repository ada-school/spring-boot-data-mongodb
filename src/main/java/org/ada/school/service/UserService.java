package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;

import java.util.Date;
import java.util.List;

/**
 * The interface User service.
 */
public interface UserService
{
    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    User create( User user );

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    User findById( String id );

    /**
     * All list.
     *
     * @return the list
     */
    List<User> all();

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById( String id );

    /**
     * Update user.
     *
     * @param userDto the user dto
     * @param id      the id
     * @return the user
     */
    User update( UserDto userDto, String id );

    /**
     * Find users with name or last name like list.
     *
     * @param queryText the query text
     * @return the list
     */
    List<User> findUsersWithNameOrLastNameLike(String queryText);

    /**
     * Find users created after list.
     *
     * @param startDate the start date
     * @return the list
     */
    List<User> findUsersCreatedAfter(Date startDate);
}
