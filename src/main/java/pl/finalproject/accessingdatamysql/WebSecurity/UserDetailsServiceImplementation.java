//package pl.finalproject.accessingdatamysql.WebSecurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import pl.finalproject.accessingdatamysql.repository.UserRepository;
//
//// pośredniczy między repository Usera a konfiguracją Springa 32:45
//@Service
//public class UserDetailsServiceImplementation implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserDetailsServiceImplementation(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userRepository.findByLogin(s);
//    }
//}
