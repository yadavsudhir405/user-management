package github.com.yadavsudhir405.userManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:11:08 PM
 *         Project:usermanagement
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException {
    private Long id;
    public GroupNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }

    public GroupNotFoundException(Long id,String message, Throwable cause) {
        super(message, cause);
        this.id = id;
    }
}
