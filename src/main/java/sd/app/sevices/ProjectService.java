package sd.app.sevices;

import sd.app.model.Project;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

public interface ProjectService {
    List<Project> getAll();
    Optional<Project> getById(long id);
    Project save(Project project);
}
