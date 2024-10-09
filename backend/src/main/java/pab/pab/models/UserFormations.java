package pab.pab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_formations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id", nullable = false)
    private Integer userId;

    @Column(name="formation_id", nullable = false)
    private Integer formationId;

    public UserFormations(Integer userId, Integer formationId) {
        this.userId = userId;
        this.formationId = formationId;
    }
    
	public UserFormations() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFormationId() {
		return formationId;
	}

	public void setFormationId(Integer formationId) {
		this.formationId = formationId;
	}
    
    
}
