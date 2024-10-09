package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pab.pab.dto.UserCreateDTO;
import pab.pab.dto.UserDTO;
import pab.pab.services.FormationService;
import pab.pab.services.UserFormationsService;
import pab.pab.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        if (Objects.isNull(userCreateDTO.getFormationIds()) || userCreateDTO.getFormationIds().isEmpty() ||
                userCreateDTO.getFormationIds().stream().allMatch(formationId -> formationService.existsFormationById(formationId))) {
            UserDTO userDTO = userService.createUser(userCreateDTO);
            if (Objects.nonNull(userCreateDTO.getFormationIds())) {
                userDTO.setFormations(userCreateDTO.getFormationIds().stream().map(formationId -> formationService.getFormationById(formationId)).toList());
            } else {
                userDTO.setFormations(new ArrayList<>());
            }
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
