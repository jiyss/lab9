package ua.edu.ucu.apps.lab9.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppUserService {
    
    private final AppUserRepository appUserRepository;
    
    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
    
    public AppUser addUser(AppUser user) {
        if (appUserRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        return appUserRepository.save(user);
    }
}
