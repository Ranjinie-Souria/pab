package pab.pab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Integer id;
    private String name;
    private LocalDateTime date;
    private Integer formationId;
    private Integer roomNb;
    private Integer duration;
}
