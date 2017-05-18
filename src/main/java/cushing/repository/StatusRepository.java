package cushing.repository;

import cushing.models.dictionary.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Nagibov
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
