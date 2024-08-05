package Support.Service.security;

import Support.Service.model.Person;
import Support.Service.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public CustomUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Person person = personRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
        GrantedAuthority authority = new SimpleGrantedAuthority(person.getRole());
        Set<GrantedAuthority> authorities = Collections.singleton(authority);

        return new CustomUserDetails(person.getPersonId(), person.getUserName(), person.getEmail(), person.getPassword(), authorities);
    }

    @Getter
    public static class CustomUserDetails extends org.springframework.security.core.userdetails.User {
        private final Long id;

        public CustomUserDetails(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, authorities);
            this.id = id;
        }

    }
}
