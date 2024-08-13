package Support.Service.service;

import Support.Service.dto.PersonDto;
import Support.Service.enums.Role;
import Support.Service.model.Person;
import Support.Service.model.User;
import Support.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User addUser(PersonDto personDto) {
        User user = new User();
        user.setUserName(personDto.getUserName());
        user.setEmail(personDto.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(personDto.getPassword()));
        return userRepository.save(user);
    }


    public List<User> getUsersByRole() {
        return userRepository.findUserByRole(Role.USER);
    }


    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setUserName(user.getUsername());
            return userRepository.save(existingUser);
        }
        return null;
    }
}

