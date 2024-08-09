//package Support.Service.config;
//import Support.Service.model.Person;
//import Support.Service.repository.PersonRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Admin implements CommandLineRunner {
//
//    private final PersonRepository personRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public Admin(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
//        this.personRepository = personRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        if (!personRepository.existsByEmail("admin@gmail.com")) {
//            Person admin = new Support.Service.model.Admin();
//            admin.setEmail("admin@gmail.com");
//            admin.setPassword(passwordEncoder.encode("admin"));
//            admin.setUserName("admin");
//            personRepository.save(admin);
//        }
//    }
//}