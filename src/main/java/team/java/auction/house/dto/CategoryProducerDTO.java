package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryProducerDTO {
    private Long id;
    private CategoryDTO category;
    private ProducerDTO producer;
}
