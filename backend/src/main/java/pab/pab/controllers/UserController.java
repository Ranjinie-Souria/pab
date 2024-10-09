package pab.pab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pab.pab.application.UserFacade;
import pab.pab.dto.UserCreateDTO;
import pab.pab.dto.UserDTO;
import pab.pab.models.UserFormations;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserFacade userFacade;
    
    @GetMapping
    public List<UserDTO> getUsers() {
        return userFacade.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Integer userId){
        return userFacade.getUserById(userId);
    }
    
    @PostMapping
    public UserDTO createUser(@RequestBody UserCreateDTO user) {
        return userFacade.createUser(user);
    }
    
    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Integer userId, @RequestBody UserCreateDTO user) {
        return userFacade.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userFacade.deleteUser(userId);
    }

    @PostMapping("/{userId}/formation")
    public void addFormationsToUser(@PathVariable Integer userId, @RequestParam(value = "formation-id") List<Integer> formationIds) {
        userFacade.addFormationsToUser(userId, formationIds);
    }

    @DeleteMapping("/{userId}/formation/{formationId}")
    public void removeFormationToUser(@PathVariable Integer userId, @PathVariable Integer formationId) {
        userFacade.removeFormationsToUser(userId, formationId);
    }
}
