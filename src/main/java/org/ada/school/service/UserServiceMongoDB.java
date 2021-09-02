package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceMongoDB
        implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserDocument userDocument=new UserDocument(user);
        userRepository.save(userDocument);
        return user;
    }

    @Override
    public User findById(String id) {
        UserDocument userDocument=(UserDocument) userRepository.findById(id).orElse(null);
        return new User(userDocument);
    }

    @Override
    public List<User> all() {
        ArrayList<UserDocument> userDocumentArrayList=(ArrayList<UserDocument>) userRepository.findAll();
        ArrayList<User> users = new ArrayList<User>();
        for (UserDocument user: userDocumentArrayList) {
            users.add(new User(user));
        }
        return users;
    }

    @Override
    public boolean deleteById(String id) {
        boolean wasDeleted=true;
        try {
            userRepository.deleteById(id);
        }
        catch(IllegalArgumentException deletedException){
            wasDeleted=false;
        }
        return wasDeleted;
    }

    @Override
    public User update(UserDto userDto, String id) {
        User updatedUser=null;
        if (userRepository.existsById(id)){
            UserDocument foundUserDocument=userRepository.findById(id).orElse(null);
            foundUserDocument.updateUserDocument(userDto);
            userRepository.save(foundUserDocument);
            updatedUser=new User(foundUserDocument);

        }
        return updatedUser;

    }
}