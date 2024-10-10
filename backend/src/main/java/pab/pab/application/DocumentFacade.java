package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;

import pab.pab.dto.DocumentDTO;
import pab.pab.services.DocumentService;

public class DocumentFacade {

    @Autowired
    private DocumentService documentService;

    public DocumentDTO createDocument(String name, String url) {
        return documentService.createDocument(name, url);
    }

    public void deleteDocument(Integer DocumentId) {
        documentService.deleteDocument(DocumentId);
    }

    public DocumentDTO getDocument(Integer DocumentId) {
        return documentService.getDocumentById(DocumentId);
    }
}
