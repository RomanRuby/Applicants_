package cushing.repository;


import cushing.models.dictionary.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Nagibov
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
