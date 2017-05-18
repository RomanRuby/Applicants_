package cushing.repository;

import cushing.models.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

     List<Interview> findAllByApplicantId(Long id);

     List<Interview> findAllByIsEnabledTrue();

     List<Interview> findAllByIsEnabledTrueAndEventDateGreaterThan(Date date);

}
