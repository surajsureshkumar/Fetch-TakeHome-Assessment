package takehome.assessment.fetch.mapper;

import org.springframework.stereotype.Component;
import takehome.assessment.fetch.dto.ItemDTO;
import takehome.assessment.fetch.dto.ReceiptDTO;
import takehome.assessment.fetch.entity.ItemEntity;
import takehome.assessment.fetch.entity.ReceiptEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to map between DTO and Entity.
 * It is used to convert the data from the DTO to the Entity and vice versa.
 */
@Component
public class ReceiptMapper{

    /**
     * The below method maps a ReceiptDTO (incoming request payload) to a ReceiptEntity object.
     * This is used to convert external JSON structure into an internal format to match the data fields
     */
    public ReceiptEntity mapJsonToEntity(ReceiptDTO dto) {
        ReceiptEntity entity = new ReceiptEntity();
        entity.setRetailer(dto.getRetailer());
        entity.setPurchaseDate(dto.getPurchaseDate());
        entity.setPurchaseTime(dto.getPurchaseTime());
        entity.setTotal(dto.getTotal());

        List<ItemEntity> items = dto.getItems().stream()
                .map(this::mapItemDtoToEntity)
                .collect(Collectors.toList());
        entity.setItems(items);

        return entity;
    }

    /**
     * Helper method to convert an ItemDTO to an ItemEntity.
     * Used during receipt mapping to transform each item in the list.
     */
    private ItemEntity mapItemDtoToEntity(ItemDTO dto) {
        ItemEntity item = new ItemEntity();
        item.setShortDescription(dto.getShortDescription());
        item.setPrice(dto.getPrice());
        return item;
    }
}
