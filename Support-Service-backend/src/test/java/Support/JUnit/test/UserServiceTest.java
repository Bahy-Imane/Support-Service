package Support.JUnit.test;

import Support.Service.dto.PersonDto;
import Support.Service.enums.Role;
import Support.Service.model.User;
import Support.Service.repository.UserRepository;
import Support.Service.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        User user = new User();
        user.setUserName("testUser");
        user.setEmail("test@example.com");

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("testUser", users.get(0).getUsername());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setUserName("testUser");
        user.setEmail("test@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    public void testAddUser() {
        PersonDto personDto = new PersonDto();
        personDto.setUserName("testUser");
        personDto.setEmail("test@example.com");
        personDto.setPassword("password");

        User user = new User();
        user.setUserName("testUser");
        user.setEmail("test@example.com");
        user.setPassword("encodedPassword");
        user.setRole(Role.USER);

        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.addUser(personDto);
        assertNotNull(savedUser);
        assertEquals("testUser", savedUser.getUsername());
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setUserName("oldUser");
        existingUser.setEmail("old@example.com");

        User updatedUser = new User();
        updatedUser.setUserName("newUser");
        updatedUser.setEmail("new@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser(1L, updatedUser);
        assertNotNull(result);
        assertEquals("newUser", result.getUsername());
        verify(userRepository).save(argThat(user ->
                "newUser".equals(user.getUsername()) &&
                        "new@example.com".equals(user.getEmail())
        ));
    }

}
