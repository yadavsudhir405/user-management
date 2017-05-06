package github.com.yadavsudhir405.userManagement.services;

import github.com.yadavsudhir405.userManagement.domain.Group;
import github.com.yadavsudhir405.userManagement.domain.GroupRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author sudhir
 *         Date:6/5/17
 *         Time:11:56 PM
 *         Project:usermanagement
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupServiceTestSuite {

    private static final Group GROUP=new Group("Admin");
    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Mock
    GroupRepository groupRepository;

    private  GroupService groupService;


    @Before
    public  void testSetUp(){
        MockitoAnnotations.initMocks(this);
        GroupRepository groupRepository= Mockito.mock(GroupRepository.class);
        Mockito.when(groupRepository.save(GROUP)).thenReturn(GROUP);
        groupService=new GroupServiceImpl(groupRepository);
    }
    @Test
    public void createGroupWhenNameIsNullShouldThrowIllegalArgumentException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("group can't be empty");
        groupService.create(null);
    }

    @Test
    public void createGroupWithEmptyNameShouldThrowIllegalArgumentException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Group name can't be empty");
        Group group=new Group(null);
        groupService.create(group);
    }


}
