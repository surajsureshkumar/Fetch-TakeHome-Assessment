package takehome.assessment.fetch.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a single item in a receipt.
 * Marked as @Embeddable so it can be embedded within ReceiptEntity via @ElementCollection.
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    private String shortDescription;
    private String price;
}
