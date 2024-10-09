package pab.pab.repositories;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import pab.pab.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{
	
	Optional<Document> findByName(String name);
	Optional<Document> findByUrl(String url);
	Optional<Document> findByDate(Timestamp date);

}

