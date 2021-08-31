package edu.eci.userapi.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.userapi.data.document.User;

public interface UserRespository extends MongoRepository<User,String> {
}
