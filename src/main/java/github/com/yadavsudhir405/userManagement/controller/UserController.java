package github.com.yadavsudhir405.userManagement.controller;

import github.com.yadavsudhir405.userManagement.domain.User;
import github.com.yadavsudhir405.userManagement.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:5:27 PM
 *         Project:usermanagement
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User add(@RequestBody User user){

        return userService.register(user);
    }
    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }
}
