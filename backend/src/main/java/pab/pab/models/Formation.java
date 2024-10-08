package pab.pab.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "formation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
