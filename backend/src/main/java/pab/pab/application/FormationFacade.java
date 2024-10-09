package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.FormationDTO;
import pab.pab.services.FormationService;

@Service
public class FormationFacade {

    @Autowired
    private FormationService formationService;

    public FormationDTO createFormation(String name, Integer year) {
        return formationService.createFormation(name, year);
    }

    public void deleteFormation(Integer formationId) {
        formationService.deleteFormation(formationId);
    }

    public FormationDTO getFormation(Integer formationId) {
        return formationService.getFormationById(formationId);
    }
}
