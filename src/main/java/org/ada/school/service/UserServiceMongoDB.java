package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserDocument userDocument = new UserDocument(user);
        userRepository.save(userDocument);
        return user;
    }

    @Override
    public User findById(String id) {
        Optional<UserDocument> userDocument = userRepository.findById(id);
        if (userDocument.isPresent()) {
            User user = new User(userDocument.get());
            return user;
        }
        return null;
    }

    @Override
    public List<User> all() {
        List<UserDocument> usersDocument = userRepository.findAll();
        List<User> users = new ArrayList();
        for (UserDocument ud : usersDocument) {
            users.add(new User(ud));
        }
        return users;
    }

    @Override
    public boolean deleteById(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User update(UserDto userDto, String id) {
        if (userRepository.existsById(id)) {
            UserDocument userDocument = userRepository.findById(id).get();
            userDocument.update(userDto);
            userRepository.save(userDocument);
            User user = new User(userDocument);
            return user;
        }
        return null;
    }

}
