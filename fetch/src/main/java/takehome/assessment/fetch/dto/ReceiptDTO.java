package takehome.assessment.fetch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class is used to transfer receipt data between layers, hiding our schema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {
    // below are the fields that are used to transfer data
    private String id;
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<ItemDTO> items;
    private String total;
    private String points;
}
