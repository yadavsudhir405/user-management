package github.com.yadavsudhir405.userManagement.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:3:45 PM
 *         Project:usermanagement
 */
@RunWith(SpringRunner.class)
@RestClientTest({RemoteUserOutStandingService.class})
public class RemoteUserOutStandingServiceTestSuite {
    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RemoteUserOutStandingService remoteUserOutStandingService;

    @Test
    public void userIsHavingOutStandingBalanceWhenNullisPassedShouldThrowIllegalArgumentExceptin(){

    }

    @Test
    public void userIsHavingOutStandingBalanceWithProperIdShouldReturnValue(){
        String url="";
        //this.server.expect(MockRestRequestMatchers.requestTo(url)).andRespond(Moc);
    }

    private ClassPathResource getClassPathResource(String path){
        return new ClassPathResource(path,getClass());
    }
}
