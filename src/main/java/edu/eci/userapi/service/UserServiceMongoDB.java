package edu.eci.userapi.service;

import edu.eci.userapi.data.repository.UserDocument;
import edu.eci.userapi.data.dto.UserDto;
import edu.eci.userapi.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDocument create(UserDocument user) {
        return userRepository.save(user);
    }

    @Override
    public UserDocument findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDocument> all() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDocument update(UserDto userDto, String id) {
        UserDocument oldUser = userRepository.findById(id).orElse(null);
        if (oldUser==null) {
            throw new NullPointerException("The user requested not exist!");
        }else{
            oldUser.update(userDto);
            userRepository.save(oldUser);
            return oldUser;
        }
    }

    @Override
    public List<UserDocument> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findUsersWithNameOrLastNameLike(queryText);
    }

    @Override
    public List<UserDocument> findUsersCreatedAfter(Date startDate) {
        return userRepository.findUserDocumentByCreatedAtAfter(startDate);
    }
}