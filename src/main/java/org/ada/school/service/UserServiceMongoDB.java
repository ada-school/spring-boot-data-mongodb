package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.exception.UserException;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user ) throws UserException {
        UserDocument u= userRepository.findById(user.getId()).orElse(null);
        if(u != null){
            throw new UserException("Este usuario ya existe");

        }
        UserDocument userD = new UserDocument(user);
        userRepository.save(userD);
        return user;
    }

    @Override
    public User create(UserDto user) throws UserException {
        return create(new User(user));
    }

    @Override
    public User findById( String id ) throws UserException {

        UserDocument user= userRepository.findById(id).orElse(null);
        if (user == null){
            throw new UserException("Usuario no existe");

        }
        return new User(user);
    }

    @Override
    public List<User> all()
    {
        ArrayList<UserDocument> users=(ArrayList<UserDocument>) userRepository.findAll();
        ArrayList<User> users1 = new ArrayList<User>();
        for (UserDocument u: users) {
            users1.add(new User(u));
        }
        return users1;
    }

    @Override
    public boolean deleteById( String id ) throws UserException {

        try {
            userRepository.deleteById(id);
        }
        catch(IllegalArgumentException deletedException){
            throw new UserException("Usuario no Existe");
        }
        return true;
    }

    @Override
    public User update( UserDto userDto, String id ) throws UserException {


        UserDocument usuarioABuscar=userRepository.findById(id).orElse(null);
        if(usuarioABuscar == null){
            throw new UserException("Usuario no existe");

        }
        usuarioABuscar.update(userDto);
        userRepository.save(usuarioABuscar);
        User u=new User(usuarioABuscar);

        return u;
    }
}
