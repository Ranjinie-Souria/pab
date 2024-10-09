package pab.pab.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "date", nullable = false)
    private Timestamp date;
    
    @Column(name = "room_nb", nullable = false)
    private Integer room_nb;
    
    @Column(name = "duration", nullable = false)
    private Integer  duration;
    
    @Column(name = "deleted_date", nullable = false)
    private Timestamp deleted_date;
    
    @ManyToOne
    @JoinColumn(name = "formation_id",
    	referencedColumnName = "id",
    	insertable = false)
    private Formation formation;
    
    

}
