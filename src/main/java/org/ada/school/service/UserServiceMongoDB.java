package org.ada.school.service;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user )
    {
        UserDocument userDocument =  new UserDocument(user.getId(), user.getName(), user.getEmail(), user.getLastName(), user.getCreatedAt());
        userRepository.save(userDocument);
        return user;
    }

    @Override
    public User findById( String id )
    {

        Optional<UserDocument> userDocumentos= userRepository.findById(id);
        UserDocument userDocument =userDocumentos.get();
        UserDto userdto = new UserDto(userDocument.getEmail(), userDocument.getName(), userDocument.getLastName());
        User user = new User(userdto);
        return user;
    }

    @Override
    public List<User> all()
    {
        List<UserDocument> listUserDocument = userRepository.findAll();
        ArrayList<User> user= new ArrayList<>();
        for(UserDocument userDocument: listUserDocument){
            user.add(new User(new UserDto(userDocument.getEmail(), userDocument.getName(), userDocument.getLastName())));
        }
        return user;
    }

    @Override
    public boolean deleteById( String id )
    {
        userRepository.deleteById(id);
        if (userRepository.findById(id)!=null){
            return true;
        }else{
        return false;
        }
    }

    @Override
    public User update(UserDto userDto, String id )
    {
        UserDocument userDocument = userRepository.findById(id).get();
        userRepository.deleteById(id);
        userDocument.setName(userDto.getName());
        userDocument.setEmail(userDto.getEmail());
        userDocument.setLastName(userDto.getLastName());
        userRepository.save(userDocument);

        UserDto userdto = new UserDto(userDocument.getEmail(), userDocument.getName(), userDocument.getLastName());
        User user = new User(userdto);
        return user;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        List<UserDocument> listUserDocument = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for(UserDocument userDocument: listUserDocument){
            if (userDocument.getName().equals(queryText) || userDocument.getLastName().equals(queryText)) {
                users.add(new User(new UserDto(userDocument.getEmail(), userDocument.getName(), userDocument.getLastName())));
            }
        }
        return users;

    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate){
        List<UserDocument> listUserDocument = userRepository.findAll();
        List<User> users = new ArrayList<>();
            for(UserDocument userDocument: listUserDocument){
                if (userDocument.getCreatedAt().after(startDate)) {
                    users.add(new User(new UserDto(userDocument.getEmail(), userDocument.getName(), userDocument.getLastName())));
                }
                }
        return users;
        }

    }
