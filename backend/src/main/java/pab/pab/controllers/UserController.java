package pab.pab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pab.pab.models.User;
import pab.pab.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
