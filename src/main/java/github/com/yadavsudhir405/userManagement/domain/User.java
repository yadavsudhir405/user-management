package github.com.yadavsudhir405.userManagement.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:4:28 PM
 *         Project:usermanagement
 */
@Entity
@Table(name = "IUSER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinTable(name = "USER_GROUP_MAPPING",joinColumns = @JoinColumn(name = "GROUP_ID"),inverseJoinColumns =
    @JoinColumn(name = "USER_ID"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Group group;

    @Transient
    private Long groupId;

    public User(){

    }
    @JsonCreator
    public User(@JsonProperty(value = "firstName") String firstName, @JsonProperty(value = "lastName") String
            lasName) {
        Assert.notNull(firstName,"firstName can't be empty");
        Assert.notNull(lasName,"lastName can't be empty");
        this.firstName = firstName;
        this.lastName = lasName;
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Group getGroup() {
        return group;
    }

   /* @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
*/
    public void setGroup(Group group) {
        this.group = group;
    }



}
