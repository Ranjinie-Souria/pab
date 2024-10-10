package pab.pab.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pab.pab.application.DocumentFacade;
import pab.pab.dto.DocumentDTO;
import pab.pab.services.DocumentService;

@RestController
@Tag(name="DOCUMENT")
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentFacade documentFacade;

    @PostMapping
    public DocumentDTO createDocument(String name, String url) {
        return documentFacade.createDocument(name, url);
    }

    @DeleteMapping
    public void deleteDocument(Integer documentId) {
        documentFacade.deleteDocument(documentId);
    }

    @GetMapping
    public DocumentDTO getDocument(Integer documentId) {
        return documentFacade.getDocument(documentId);
    }
    
}
