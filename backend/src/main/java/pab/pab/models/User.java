package pab.pab.models;

import jakarta.persistence.*;
import lombok.*;
import pab.pab.models.Formation;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "formation_id", referencedColumnName = "id", insertable = false)
    private Formation formation;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "update_date")
    private java.sql.Timestamp updateDate;
    
}
