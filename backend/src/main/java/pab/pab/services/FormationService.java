package pab.pab.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.FormationDTO;
import pab.pab.models.Formation;
import pab.pab.repositories.FormationRepository;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public FormationDTO createFormation(String name, Integer year) {
        Formation formation = new Formation();
        formation.setName(name);
        formation.setYear(year);
        return modelMapper.map(formationRepository.save(formation), FormationDTO.class);
    }

    public void deleteFormation(Integer formationId) {
        formationRepository.deleteById(formationId);
    }

    public FormationDTO getFormationById(Integer formationId) {
        return modelMapper.map(formationRepository.findById(formationId).get(), FormationDTO.class);
    }

    public Boolean existsFormationById(Integer formationId) {
        return formationRepository.existsById(formationId);
    }
}
