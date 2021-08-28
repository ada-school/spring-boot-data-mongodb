package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return new User(userRepository.save(new UserDocument(user)));
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id).
                map(doc -> new User(doc));
    }

    @Override
    public List<User> all() {
        return userRepository.findAll()
                .stream()
                .map(doc -> new User(doc))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        User user = userRepository.findById(id)
                .map(doc -> new User(doc))
                .get();
        if (user != null) {
            user.update(userDto);
            deleteById(id);
            create(user);
        }
        return user;
    }
}
