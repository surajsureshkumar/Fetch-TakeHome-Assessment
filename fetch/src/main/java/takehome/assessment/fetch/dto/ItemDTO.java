package takehome.assessment.fetch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to transfer item data between layers, hidiing our schema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String shortDescription;
    private String price;
}
