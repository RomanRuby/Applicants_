package cushing.repository;

import cushing.models.dictionary.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Nagibov
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
