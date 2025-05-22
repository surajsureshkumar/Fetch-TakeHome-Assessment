package takehome.assessment.fetch.service;

import org.springframework.stereotype.Service;
import takehome.assessment.fetch.dto.ReceiptDTO;
import takehome.assessment.fetch.entity.ItemEntity;
import takehome.assessment.fetch.entity.ReceiptEntity;
import takehome.assessment.fetch.mapper.ReceiptMapper;
import takehome.assessment.fetch.repository.ReceiptRepository;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class implements business logic for handling receipts.
 * It calculates points based on the receipt data and stores them in a map.
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{

    private final Map<String, Integer> idToPoints = new ConcurrentHashMap<>(); // map to store points
    private final ReceiptMapper receiptMapper; // mapper to convert DTO to Entity and vice versa

    // constructor injection
    public ReceiptServiceImpl(ReceiptMapper receiptMapper) {
        this.receiptMapper = receiptMapper;
    }

    @Override
    // method to get points for a receipt
    public int getPoints(String id) {
        Integer points = idToPoints.get(id); //get the points from the map using the id generated for the receipt
        // if points is null, it means the id is not found in the map
        if (points == null) {
            throw new IllegalArgumentException("Receipt ID not found: " + id);
        }
        return points; // successfully return the points if points are populated
    }

    // method to calculate points based on the receipt data and the rules mentioned in the github readme
    // no large language model was used to generate this code, so I have removed the conditions
    // that were not mentioned in the readme regarding +5 points for using LLM.
    private int calculatePoints(ReceiptEntity receipt) {
        int points = 0; // to store points

        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length(); // rule 1

        if (receipt.getTotal().matches("\\d+\\.00")) points += 50; // rule 2

        if (new BigDecimal(receipt.getTotal()).remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0)
            points += 25; // rule 3

        points += (receipt.getItems().size() / 2) * 5; // rule 4

        // lines 58 - 67 are for rule 5
        for (ItemEntity item : receipt.getItems()) {
            String desc = item.getShortDescription().trim();
            int len = desc.length();

            if (len % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                int bonus = (int) Math.ceil(price * 0.2);
                System.out.println("Matched item: " + desc + " | length: " + len + " | bonus: " + bonus);
                points += bonus;
            }
        }
        if (Integer.parseInt(receipt.getPurchaseDate().split("-")[2]) % 2 == 1) points += 6; // rule 7

        // lines 72 - 74 are for rule 8
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (time.isAfter(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) points += 10;

        return points; // return the total points
    }

    @Override
    // method to write the receipt to the database
    public String writeToDB(ReceiptDTO receiptDTO) {
        ReceiptEntity entity = receiptMapper.mapJsonToEntity(receiptDTO); // convert DTO to Entity
        int points = calculatePoints(entity); // calculate points based on the rules
        String id = UUID.randomUUID().toString(); // generate a unique id for the receipt
        idToPoints.put(id, points); // store the points in the map with the id as key
        return id; // return the id of the receipt
    }
}
