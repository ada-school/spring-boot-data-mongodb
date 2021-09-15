package org.ada.school.repository;

import org.ada.school.model.User;
import org.ada.school.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * The interface User repository.
 */
public interface UserRepository extends MongoRepository<UserDocument, String>
{
    /**
     * Find by name or last name like list.
     *
     * @param name     the name
     * @param LastName the last name
     * @return the list
     */
    List<UserDocument> findByNameOrLastNameLike(String name, String LastName);

    /**
     * Find by created at after list.
     *
     * @param createdAt the created at
     * @return the list
     */
    List<UserDocument> findByCreatedAtAfter(Date createdAt);
}
