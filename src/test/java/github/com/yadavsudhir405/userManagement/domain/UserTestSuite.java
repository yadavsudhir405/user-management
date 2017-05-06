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
 *         Time:1:58 PM
 *         Project:usermanagement
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTestSuite {

    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveUserWithEmptyFirstNameShouldThrowIllegalArgumentException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("firstName can't be empty");
        User user=new User(null,"lastName");

    }

    @Test
    public void saveUserWithEmptyLastNameShouldThrowIllegalArgumentException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("lastName can't be empty");
        User user=new User("firstName",null);

    }
    @Test
    public void saveUserWithFirstNameAndLastNameShouldSave(){
        User user=testEntityManager.persistFlushFind(new User("fname","lname"));
        Assertions.assertThat(user.getFirstName()).isEqualTo("fname");
        Assertions.assertThat(user.getLastName()).isEqualTo("lname");
    }

    @Test
    public void saveUserWithGroupShouldSave(){
        Group group=testEntityManager.persistAndFlush(new Group("Admin"));
        User user=new User("Sudhir","Yadav");
        user.setGroup(group);
        User actualUserFromDb=testEntityManager.persistAndFlush(user);
        Assertions.assertThat(actualUserFromDb.getGroup().getId()).isEqualTo(group.getId());
    }
}
