package github.com.yadavsudhir405.userManagement.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:5/5/17
 *         Time:4:48 PM
 *         Project:usermanagement
 */
@JsonPropertyOrder({"id","name"})
@Entity
@Table(name = "IGroup")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private  String name;

    protected Group(){

    }

    @JsonCreator
    public Group(@JsonProperty(value = "name") String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        return name != null ? name.equals(group.name) : group.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
