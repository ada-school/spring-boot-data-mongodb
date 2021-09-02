package org.ada.school.repository;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument, String>
{
    User create(User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update(UserDto userDto, String id );
}
