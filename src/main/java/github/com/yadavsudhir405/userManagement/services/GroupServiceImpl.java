package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.domain.GroupRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:10:27 AM
 *         Project:usermanagement
 */
@Component
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public void remove(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public void removeByName(String name) {
        groupRepository.removeByName(name);
    }
}
