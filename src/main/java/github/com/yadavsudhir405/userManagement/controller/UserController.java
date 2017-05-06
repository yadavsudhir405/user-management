package github.com.yadavsudhir405.userManagement.controller;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.domain.User;
import github.com.yadavsudhir405.userManagement.services.GroupService;
import github.com.yadavsudhir405.userManagement.services.UserService;
import org.springframework.util.Assert;
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

    private final GroupService groupService;

    public UserController(UserService userService,GroupService groupService) {
        this.userService = userService;
        this.groupService=groupService;
    }

    @PostMapping
    public User add(@RequestBody User user){

        return userService.register(user);
    }
    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }
    @GetMapping(path = "/groups/{id}")
    public List<User> usersByGroup(@PathVariable Long id){
        Assert.notNull("id","GroupId can't be null");
        Group group=groupService.findById(id);
        return userService.findByGroup(group);

    }

}
