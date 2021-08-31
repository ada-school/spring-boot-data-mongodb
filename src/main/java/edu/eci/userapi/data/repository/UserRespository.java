package edu.eci.userapi.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRespository extends MongoRepository<UserDocument,String> {
}
