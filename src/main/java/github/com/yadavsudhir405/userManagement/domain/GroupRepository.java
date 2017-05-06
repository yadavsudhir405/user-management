package github.com.yadavsudhir405.userManagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:5:05 PM
 *         Project:usermanagement
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findById(Long id);
    Group findByName(String name);
    Long removeByName(String name);
}
