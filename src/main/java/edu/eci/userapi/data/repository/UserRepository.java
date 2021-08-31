package edu.eci.userapi.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.userapi.data.repository.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument,String> {
}
