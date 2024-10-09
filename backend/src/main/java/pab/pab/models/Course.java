package pab.pab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "room_nb", nullable = false)
	private Integer roomNb;
	
	@Column(name = "duration", nullable = false)
	private Integer duration;
	
	@Column(name = "deleted_date")
    private LocalDateTime deleted_date;

	@ManyToOne
	@JoinColumn(name = "formation_id", referencedColumnName = "id", insertable = false)
	private Formation formation;

}
