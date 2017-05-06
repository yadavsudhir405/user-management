package github.com.yadavsudhir405.userManagement.controller;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.domain.User;
import github.com.yadavsudhir405.userManagement.services.GroupService;
import github.com.yadavsudhir405.userManagement.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:6:17 PM
 *         Project:usermanagement
 */
@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    private final GroupService groupService;

    private final UserService userService;

    public GroupController(GroupService groupService,UserService userService) {
        this.groupService = groupService;
        this.userService=userService;
    }

    @PostMapping
    public Group create(@RequestBody Group group){
        return groupService.create(group);
    }
    @GetMapping
    public List<Group> findAll(){
        return groupService.findAll();
    }
    @DeleteMapping
    public void remove(@RequestBody Group group){
        groupService.remove(group);
    }
    @GetMapping(path = "name/{name}")
    public Group findByName(@PathVariable String name){
        return groupService.findByName(name);
    }
    @GetMapping(path = "id/{id}")
    public Group findById(@PathVariable Long id){
        return groupService.findById(id);
    }
    @DeleteMapping(path="name/{name}")
    public void deleteByName(@PathVariable String name){
        groupService.removeByName(name);
    }

    @GetMapping(path = "/{id}/users")
    public List<User> getAllUserFromGroup(@PathVariable String id){
        return userService.findByGroup(Long.valueOf(id));
    }

}
