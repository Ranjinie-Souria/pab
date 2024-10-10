package pab.pab.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import pab.pab.dto.DocumentDTO;
import pab.pab.models.Document;
import pab.pab.repositories.DocumentRepository;

public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public DocumentDTO createDocument(String name, String url) {
        Document Document = new Document();
        Document.setName(name);
        Document.setUrl(url);
        Document.setDate(new Timestamp(new Date().getTime()));
        return modelMapper.map(documentRepository.save(Document), DocumentDTO.class);
    }

    public void deleteDocument(Integer DocumentId) {
        documentRepository.deleteById(DocumentId);
    }

    public DocumentDTO getDocumentById(Integer DocumentId) {
        return modelMapper.map(documentRepository.findById(DocumentId).get(), DocumentDTO.class);
    }

    public Boolean existsDocumentById(Integer DocumentId) {
        return documentRepository.existsById(DocumentId);
    }

    
}
