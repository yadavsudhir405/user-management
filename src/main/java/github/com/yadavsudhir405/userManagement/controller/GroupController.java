package github.com.yadavsudhir405.userManagement.controller;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.services.GroupService;
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

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
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

}
