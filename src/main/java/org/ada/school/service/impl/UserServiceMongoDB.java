package org.ada.school.service.impl;

import com.mongodb.MongoException;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.model.UserDocument;
import org.ada.school.repository.UserRepository;
import org.ada.school.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceMongoDB implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceMongoDB.class);

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user )
    {
        try{
            UserDocument userDocument = new UserDocument(user);
            userRepository.save(userDocument);
        }catch(MongoException e){
            logger.error("Error creating new user: ", e);
        }
        return user;
    }

    @Override
    public User findById( String id )
    {
        User user = null;
        try{
            Optional<UserDocument> userFind = userRepository.findById(id);
            if(userFind.isPresent()){
                user = new User(userFind.get());
            }
        }catch(MongoException e){
            logger.error("Error finding user by id: ",e);
        }
        return user;
    }

    @Override
    public List<User> all()
    {
        List<UserDocument> allUsersDocuments = new ArrayList<>();
        try{
            allUsersDocuments = userRepository.findAll();
        }catch(MongoException e){
            logger.error("Error finding all users: ",e);
        }
        return allUsersDocuments.stream().map(User::new).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById( String id )
    {
        try{
            userRepository.deleteById(id);
        }catch(MongoException e){
            logger.error("Error delete user by Id: ",e);
        }
        return !userRepository.existsById(id);
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        UserDocument updatedUserDocument = null;
        try{
            Optional<UserDocument> user = userRepository.findById(id);
            if(user.isPresent()){
                updatedUserDocument = user.get().updateData(userDto);
                userRepository.save(updatedUserDocument);
            }
        }catch(MongoException e){
            logger.error("Error updating user: ",e);
        }
        return new User(updatedUserDocument);
    }
}
