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
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user )
    {
        UserDocument nuevo=new UserDocument(user);
        userRepository.save(nuevo);
        return user;
    }

    @Override
    public User findById( String id )
    {
        User reto=new User(userRepository.findById(id).orElse(null));
        return reto;
    }

    @Override
    public List<User> all()
    {
        ArrayList <UserDocument> docu=(ArrayList<UserDocument>) userRepository.findAll();
        ArrayList<User> use=new ArrayList<User>();
        for (UserDocument i:docu){
            use.add(new User(i));
        }
        return use;
    }

    @Override
    public boolean deleteById( String id )
    {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    @Override
    public User update(UserDto userDto, String id )
    {
        User us2=null;
        if(userRepository.existsById(id)){
            UserDocument us=userRepository.findById(id).orElse(null);
            us2=new User(us);
            us2.update(userDto);
            userRepository.save(new UserDocument(us2));
        }
        return us2;
    }
}