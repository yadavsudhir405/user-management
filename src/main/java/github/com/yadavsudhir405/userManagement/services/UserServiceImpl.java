package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.User;
import github.com.yadavsudhir405.userManagement.domain.UserRepository;
import org.springframework.stereotype.Component;

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

    public UserServiceImpl(UserRepository userRepository,RemoteUserOutStandingService remoteUserOutStandingService) {
        this.userRepository = userRepository;
        this.remoteUserOutStandingService=remoteUserOutStandingService;
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
}
