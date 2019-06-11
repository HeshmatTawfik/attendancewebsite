package attendancewebsite.controller;

import attendancewebsite.data.UserRepository;
import attendancewebsite.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserRepositoryUserDetailsService implements UserDetailsService {
    private UserRepository userRepo;
    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepo){
        this.userRepo=userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user =userRepo.findBystudentName(username);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User '"+username+"' not found");
    }
}
