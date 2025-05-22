package takehome.assessment.fetch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * This class is used to represent schema of our application used intenally
 * This helps us store the receipt data in the database.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id = UUID.randomUUID().toString(); // to generate a unique id as shown in the example
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    //@ElementCollection is used to represent embedded item details which are the shortDescription and price
    @ElementCollection
    private List<ItemEntity> items;
    private String total;
    private String points;
}
