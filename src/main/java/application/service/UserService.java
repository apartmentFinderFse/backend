package application.service;


import application.model.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User insertUser(User user){
        return userRepository.insert(user);

    }

    public Optional<User> findUserByUserName(User user){
        return userRepository.findUserByUserName(user.getUserName(), user.getPassword());

    }


}
