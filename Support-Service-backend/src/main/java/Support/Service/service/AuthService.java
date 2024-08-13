package Support.Service.service;

import Support.Service.dto.JwtAuthResponse;
import Support.Service.dto.LoginDto;
import Support.Service.dto.SignUpDto;
import Support.Service.enums.Role;
import Support.Service.jwt.JwtTokenProvider;
import Support.Service.model.Admin;
import Support.Service.model.Person;
import Support.Service.model.User;
import Support.Service.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PersonRepository personRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthResponse login(LoginDto loginDto) {
        System.out.println("hyyyyyyyyy222222");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrEmail(),
                loginDto.getPassword()
        ));

        System.out.println("authetication"+authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("passsssssssssse");
        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println("token"+token);
        Person person = personRepository.findByUserNameOrEmail(loginDto.getUserNameOrEmail(), loginDto.getUserNameOrEmail());
        System.out.println("person"+person);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setAccessToken(token);
        response.setTokenType("Bearer");
        response.setUserName(person.getUsername());
        response.setRole(String.valueOf(person.getRole()));
        response.setPersonId(person.getPersonId());
        System.out.println("response"+response);
        return response;
    }


    public String signUp(SignUpDto signUpDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Person person = new Admin();
        person.setUserName(signUpDto.getUserName());
        person.setEmail(signUpDto.getEmail());
        person.setRole(Role.ADMIN);
        person.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        personRepository.save(person);

        return "User registered successfully!";
    }
    }

