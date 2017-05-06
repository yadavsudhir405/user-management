package github.com.yadavsudhir405.userManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:10:19 PM
 *         Project:usermanagement
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private Long id;
    public UserNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }
    public UserNotFoundException(Long id,String message,Throwable throwable){
        super(message,throwable);
        this.id=id;
    }
}
