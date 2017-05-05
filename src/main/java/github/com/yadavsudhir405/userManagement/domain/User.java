package github.com.yadavsudhir405.userManagement.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:4:28 PM
 *         Project:usermanagement
 */
@Entity
@Table(name = "IUSER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    //private String joinedDate;

    protected User(){

    }
    @JsonCreator
    public User(@JsonProperty(value = "firstName") String firstName, @JsonProperty(value = "lastName") String
            lasName) {
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

   /* public String getJoinedDate() {
        return joinedDate;
    }*/


}
