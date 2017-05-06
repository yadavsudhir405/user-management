package github.com.yadavsudhir405.userManagement.controller;

import github.com.yadavsudhir405.userManagement.services.RemoteUserOutStandingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:3:34 PM
 *         Project:usermanagement
 */
@RestController
@RequestMapping(path = "/useroutstanding")
public class OutStandingValidatorController {
    private RemoteUserOutStandingService remoteUserOutStandingService;

    @GetMapping(path = "{id}")
    public Boolean getStatus(@PathVariable Long id){
        boolean status= remoteUserOutStandingService.userIsHavingOutStandingBalance(id);
        System.out.println(status);
        return status;
    }
}
