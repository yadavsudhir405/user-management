package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.Group;

import java.util.List;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:10:26 AM
 *         Project:usermanagement
 */
public interface GroupService {
    Group create(Group group);
    List<Group> findAll();
    Group findById(Long id);
    Group findByName(String name);
    void remove(Group group);
    void removeByName(String name);
}
