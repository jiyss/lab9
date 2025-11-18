package ua.edu.ucu.apps.lab9.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    
    private final AppUserService appUserService;
    
    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    
    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }
    
    @PostMapping
    public AppUser addUser(@RequestBody AppUser user) {
        return appUserService.addUser(user);
    }
}
