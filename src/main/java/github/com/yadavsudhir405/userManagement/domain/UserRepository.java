package github.com.yadavsudhir405.userManagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:5:03 PM
 *         Project:usermanagement
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findById(Long id);
    public List<User> findByGroup(Group group);

}
