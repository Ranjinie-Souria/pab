package pab.pab.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pab.pab.application.FormationFacade;
import pab.pab.dto.FormationDTO;

@RestController
@Tag(name = "FORMATION")
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationFacade formationFacade;

    @PostMapping
    public FormationDTO createFormation(@RequestParam(value="name") String name,
                                        @RequestParam(value="year") Integer year) {
        return formationFacade.createFormation(name, year);
    }

    @DeleteMapping("/{formationId}")
    public void deleteFormation(@PathVariable Integer formationId) {
        formationFacade.deleteFormation(formationId);
    }

    @GetMapping("/{formationId}")
    public FormationDTO getFormation(@PathVariable Integer formationId) {
        return formationFacade.getFormation(formationId);
    }
}
