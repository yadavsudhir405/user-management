package github.com.yadavsudhir405.userManagement.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:2:53 PM
 *         Project:usermanagement
 */
@Component
public class RemoteUserOutStandingService {
    private static final Logger LOGGER= LoggerFactory.getLogger(RemoteUserOutStandingService.class);
    private final RestTemplate restTemplate;
    private static final String URL="http//10.132.127.131:8080/";
    public RemoteUserOutStandingService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean userIsHavingOutStandingBalance(Long id){
        Assert.notNull(id,"id can't be empty");
        try{
            return restTemplate.getForObject(URL,Boolean.class);
        } catch (Exception ex){
            LOGGER.error(ex.getMessage(),ex);
            throw new RuntimeException("Error While calling Remote Service "+URL);
        }
    }
}
