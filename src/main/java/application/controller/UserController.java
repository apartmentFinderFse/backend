package application.controller;

import application.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import application.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users registerUser( @RequestBody Users user) {
        LOGGER.info("Entering");
        user.setId(user.getUserName());
        return userRepository.insert(user);
    }

    @GetMapping("/")
    public String index() {
        LOGGER.info("test line");
        return "Greetings from Spring Boot!";
    }
}
