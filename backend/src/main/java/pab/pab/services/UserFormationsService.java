package pab.pab.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.FormationDTO;
import pab.pab.models.Formation;
import pab.pab.models.UserFormations;
import pab.pab.repositories.FormationRepository;
import pab.pab.repositories.UserFormationsRepository;

import java.util.List;

@Service
public class UserFormationsService {

    @Autowired
    private UserFormationsRepository userFormationsRepository;
    @Autowired
    private FormationRepository formationRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public void addFormationToUser(Integer userId, Integer formationId) {
        UserFormations userFormations = new UserFormations();
        userFormations.setUserId(userId);
        userFormations.setFormationId(formationId);
        userFormationsRepository.save(userFormations);
    }

    public void removeFormationToUser(Integer userId, Integer formationId) {
        userFormationsRepository.deleteByUserIdAndFormationId(userId, formationId);
    }

    public List<FormationDTO> getAllFormationsForUser (Integer userId) {
        List<UserFormations> userFormationsList = userFormationsRepository.findByUserId(userId);
        List<Formation> formations = userFormationsList.stream().map(userFormations -> formationRepository.findById(userFormations.getFormationId()).get()).toList();
        return formations.stream().map(formation -> modelMapper.map(formation, FormationDTO.class)).toList();
    }

}
