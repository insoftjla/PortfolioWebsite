package sd.app.contrillers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sd.app.sevices.ProjectService;

/**
 * @author Sergey Inyakin
 */

@Controller
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute(projectService.getAll());
        return "projects";
    }

}
