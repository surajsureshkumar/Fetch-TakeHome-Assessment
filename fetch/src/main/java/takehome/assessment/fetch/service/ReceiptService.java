package takehome.assessment.fetch.service;

import takehome.assessment.fetch.dto.ReceiptDTO;

/**
 * The service interface defines the methods for the business logic of the application.
 */
public interface ReceiptService {
    int getPoints(String id);
    String writeToDB(ReceiptDTO receiptDTO);
}
