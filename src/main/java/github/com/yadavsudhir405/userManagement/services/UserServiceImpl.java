package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.domain.User;
import github.com.yadavsudhir405.userManagement.domain.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:5:23 PM
 *         Project:usermanagement
 */
@Component
public class UserServiceImpl implements UserService {

    private RemoteUserOutStandingService remoteUserOutStandingService;
    private final UserRepository userRepository;
    private final GroupService groupService;

    public UserServiceImpl(UserRepository userRepository,RemoteUserOutStandingService remoteUserOutStandingService,
                           GroupService groupService) {
        this.userRepository = userRepository;
        this.remoteUserOutStandingService=remoteUserOutStandingService;
        this.groupService=groupService;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        if(remoteUserOutStandingService.userIsHavingOutStandingBalance(user.getId())){
            throw new RuntimeException("User is having outstanding balance so can bt delelted");
        }else {
            userRepository.delete(user);
        }

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByFirstName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByGroup(Long id) {
        Assert.notNull(id,"Group id can't be null");
        Group group=groupService.findById(id);
        return userRepository.findByGroup(group);
    }
}
