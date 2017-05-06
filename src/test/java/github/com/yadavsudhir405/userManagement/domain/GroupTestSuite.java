package github.com.yadavsudhir405.userManagement.domain;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:1:46 PM
 *         Project:usermanagement
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupTestSuite {

    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveGroupWithGroupNameShouldSaveGroup(){
        Group group=this.testEntityManager.persistFlushFind(new Group("Admin"));
        Assertions.assertThat(group.getName()).isNotEmpty();
        Assertions.assertThat(group.getName()).isEqualTo("Admin");
    }
}
