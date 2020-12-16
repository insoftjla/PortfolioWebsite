package sd.app.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.app.model.Project;

/**
 * @author Sergey Inyakin
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
