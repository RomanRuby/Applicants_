package cushing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Roman Nagibov
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
