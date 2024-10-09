package pab.pab.models;

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
@Table(name = "attendance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private java.sql.Timestamp date;

    @Column(name = "status", nullable = false)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "course_id",
    	referencedColumnName = "id",
    	insertable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "user_id",
    	referencedColumnName = "id",
    	insertable = false)
    private User user;
    

}
