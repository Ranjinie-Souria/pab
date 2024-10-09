package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.UserCreateDTO;
import pab.pab.dto.UserDTO;
import pab.pab.services.FormationService;
import pab.pab.services.UserFormationsService;
import pab.pab.services.UserService;

import java.util.List;

@Service
public class UserFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private FormationService formationService;
    @Autowired
    private UserFormationsService userFormationsService;

    public UserDTO getUserById(Integer id) {
        UserDTO userDTO = userService.getUserById(id);
        userDTO.setFormations(userFormationsService.getAllFormationsForUser(userDTO.getId()));
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = userService.getUsers();
        userDTOS.forEach(userDTO -> userDTO.setFormations(userFormationsService.getAllFormationsForUser(userDTO.getId())));
        return userDTOS;
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getFormationIds().isEmpty() ||
                userCreateDTO.getFormationIds().stream().allMatch(formationId -> formationService.existsFormationById(formationId))) {
            UserDTO userDTO = userService.createUser(userCreateDTO);
            userDTO.setFormations(userCreateDTO.getFormationIds().stream().map(formationId -> formationService.getFormationById(formationId)).toList());
            return userDTO;
        }
        throw new RuntimeException("A formation does not exist");
    }

    public UserDTO updateUser(Integer userId, UserCreateDTO userCreateDTO) {
        return userService.updateUser(userId, userCreateDTO);
    }

    public void deleteUser(Integer userId) {
        if (userService.userExist(userId)) {
            userFormationsService.getAllFormationsForUser(userId).forEach(formation -> formationService.deleteFormation(formation.getId()));
            userService.deleteUser(userId);
        }
    }

    public void addFormationsToUser(Integer userId, List<Integer> formations) {
        if (userService.userExist(userId) && formations.stream().allMatch(formationId -> formationService.existsFormationById(formationId))) {
            formations.forEach(formationId -> userFormationsService.addFormationToUser(userId, formationId));
        }
    }

    public void removeFormationsToUser(Integer userId, Integer formationId) {
        userFormationsService.removeFormationToUser(userId, formationId);
    }
}
