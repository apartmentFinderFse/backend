package application.controller;

import application.model.User;
import application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private UserService userService;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        LOGGER.info("Registering a user {}", user.getUserName());
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public String index() {
        LOGGER.info("test line");
        return "Greetings from User Controller!";
    }

    @GetMapping("login")
    public ResponseEntity<Optional<User>> findUser(@RequestBody User user) {
        LOGGER.info("Fetching details of user {}", user.getUserName());
        return new ResponseEntity<>(userService.findUserByUserName(user), HttpStatus.OK);
    }
}
