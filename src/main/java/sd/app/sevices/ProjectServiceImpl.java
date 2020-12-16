package sd.app.sevices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sd.app.model.Project;
import sd.app.repositoryes.ProjectRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
