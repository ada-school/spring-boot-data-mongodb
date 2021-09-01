package edu.eci.userapi.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument,String> {

    @Query("{ $or: [ {'name': { $regex: ?0 } }, { 'lastName': { $regex: ?0 } } ] }")
    List<UserDocument> findUsersWithNameOrLastNameLike(String queryText);

}
