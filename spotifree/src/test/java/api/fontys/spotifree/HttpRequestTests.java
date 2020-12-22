package api.fontys.spotifree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import api.fontys.spotifree.Wrappers.Wrapper;
import api.fontys.spotifree.entity.User;
import api.fontys.spotifree.repository.UserRepository;
import api.fontys.spotifree.service.MyUserDetailService;

@ExtendWith(SpringExtension.class)
public class HttpRequestTests {

    private User _users;

    public HttpRequestTests() {
        _users = new User();
        _users.setUsername("emirhan123");
        _users.setPassword("test1234");
    }

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
 
        @Bean
        public UserDetailsService userService() {
            return new MyUserDetailService();
        }
    }

    @Autowired
    private MyUserDetailService userService;

    @MockBean
    private PasswordEncoder crypt;

    @MockBean
    private UserRepository UserRepository;

    @Test
    public void AuthenticateUserInWrapperTest() {
        Wrapper wrapper = new Wrapper();

        //Act
        wrapper.AuthenticateUser(_users);

        //Assert
        assertThat(_users.getUsername()).isEqualTo("emirhan123");
    }

    @Test
    public void AddUserTest() {
    
        //Act
        userService.addUser(_users);
        //Assert
        assertThat(_users.getUsername()).matches("emirhan123");
    }
}
