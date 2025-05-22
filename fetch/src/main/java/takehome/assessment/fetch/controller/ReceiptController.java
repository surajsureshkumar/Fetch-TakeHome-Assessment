package takehome.assessment.fetch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import takehome.assessment.fetch.dto.ReceiptDTO;
import takehome.assessment.fetch.service.ReceiptServiceImpl;

import java.util.HashMap;
import java.util.Map;

/*
 * This class handles endpoints related to receipts.
 * Endpoints for processing receipts and retrieving points.
 */
@RestController
@RequestMapping("receipts")
public class ReceiptController {
    // we are getting an instance of the receiptServiceImpl to access its methods
    private final ReceiptServiceImpl receiptServiceImpl;

    // controller injection
    public ReceiptController(ReceiptServiceImpl receiptServiceImpl) {
        this.receiptServiceImpl = receiptServiceImpl;
    }

    // post request to process a receipt
    @PostMapping("/process")
    public ResponseEntity<Map<String, String>> processReceipt(@RequestBody ReceiptDTO receiptDTO) {
        String id = receiptServiceImpl.writeToDB(receiptDTO); // invoke writeToDB method to get the id
        Map<String, String> response = new HashMap<>(); // Hashmap to store the response
        response.put("id", id); // adds the id to the response and return it
        return ResponseEntity.ok(response); // return the id with 200 OK
    }

    // get method to get points for receipt(s)
    @GetMapping("/{id}/points")
    // since the id associated with the receipt is needed to get the points for that receipt, id is passed as path
    // variable
    public ResponseEntity<Map<String, Integer>> getPoints(@PathVariable String id) {
        int points = receiptServiceImpl.getPoints(id); // invoke getPoints to fetch the points
        Map<String, Integer> response = new HashMap<>(); // hashmap to store the response which is points
        response.put("points", points); // here we add the points to our hashmap
        return ResponseEntity.ok(response); // return the points with 200 OK
    }
}
