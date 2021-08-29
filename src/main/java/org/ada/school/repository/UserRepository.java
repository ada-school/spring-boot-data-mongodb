package org.ada.school.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends MongoRepository<UserDocument, String> {

	List<UserDocument> findByNameOrLastNameIsLike(final String name, final String lastName);

	List<UserDocument> findByCreatedAtAfter(final Date createdAt);

}
