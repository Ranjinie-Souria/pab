package pab.pab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pab.pab.dto.DocumentDTO;
import pab.pab.services.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    public DocumentDTO createDocument(String name, String url) {
        return documentService.createDocument(name, url);
    }

    public void deleteDocument(Integer documentId) {
        documentService.deleteDocument(documentId);
    }

    public DocumentDTO getDocument(Integer documentId) {
        return documentService.getDocumentById(documentId);
    }
    
}
