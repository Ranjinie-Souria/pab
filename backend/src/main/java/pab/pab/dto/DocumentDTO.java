package pab.pab.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private Integer id;
    private String name;
    private LocalDateTime date;
    private String url;
}