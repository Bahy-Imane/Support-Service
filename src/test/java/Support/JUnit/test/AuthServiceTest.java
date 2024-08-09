package Support.JUnit.test;

import Support.Service.dto.JwtAuthResponse;
import Support.Service.dto.LoginDto;
import Support.Service.dto.SignUpDto;

import Support.Service.jwt.JwtTokenProvider;
import Support.Service.model.Person;
import Support.Service.model.User;
import Support.Service.repository.PersonRepository;
import Support.Service.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserNameOrEmail("testUser");
        loginDto.setPassword("password");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        Person person = new User();
        person.setUserName("testUser");
        person.setPersonId(1L);

        when(personRepository.findByUserNameOrEmail(anyString(), anyString())).thenReturn(person);
        when(jwtTokenProvider.generateToken(any(Authentication.class))).thenReturn("mockToken");

        JwtAuthResponse response = authService.login(loginDto);

        assertNotNull(response);
        assertEquals("mockToken", response.getAccessToken());
        assertEquals("Bearer", response.getTokenType());
        assertEquals("testUser", response.getUserName());
        assertEquals(1L, response.getPersonId());

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(personRepository).findByUserNameOrEmail(anyString(), anyString());
        verify(jwtTokenProvider).generateToken(any(Authentication.class));
    }

    @Test
    public void testSignUp() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUserName("testUser");
        signUpDto.setEmail("test@example.com");
        signUpDto.setPassword("password");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        String result = authService.signUp(signUpDto);

        assertEquals("User registered successfully!", result);
        verify(personRepository).save(any(Person.class));
    }
}
