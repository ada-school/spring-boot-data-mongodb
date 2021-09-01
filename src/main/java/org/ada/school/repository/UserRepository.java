package org.ada.school.repository;

import java.util.Date;
import java.util.List;

import org.ada.school.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * MongoDB User Repository
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByNameOrLastNameIsLike(final String name, final String lastName);

	List<User> findByCreatedAtAfter(final Date createdAt);

}
