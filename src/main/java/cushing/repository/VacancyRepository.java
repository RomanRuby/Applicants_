package cushing.repository;

import cushing.models.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Roman Nagibov
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
