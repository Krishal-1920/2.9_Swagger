package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("dev")
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    // We will mock this
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
       //  when(userRepository.findByUserName(ArgumentMatcher.anyString())).thenReturn((net.engineeringdigest.journalApp.entity.User) User.builder().username("abc").password("bkvhbfv").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsServiceImpl.loadUserByUsername("abc");
        Assertions.assertNotNull(user);

    }

}
