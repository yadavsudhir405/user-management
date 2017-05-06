package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.User;

import java.util.List;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:5:21 PM
 *         Project:usermanagement
 */
public interface UserService {
    User register(User user);
    void remove(User user);
    User findById(Long id);
    List<User> findByFirstName(String name);
    List<User> findAll();
    List<User> findByGroup(Long id);
}
