package takehome.assessment.fetch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takehome.assessment.fetch.entity.ReceiptEntity;

/**
 * This interface is used to access the database for receipt data.
 * It extends JpaRepository to provide CRUD operations.
 * The ReceiptEntity is the entity class and String is the type of the primary key.
 */
@Repository
public interface ReceiptRepository extends JpaRepository<ReceiptEntity, String> {
}
