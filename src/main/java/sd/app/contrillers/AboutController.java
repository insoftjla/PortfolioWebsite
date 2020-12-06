package sd.app.contrillers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sd.app.sevices.UserService;

/**
 * @author Sergey Inyakin
 */

@Controller
@AllArgsConstructor
public class AboutController {

    private final UserService userService;

    @GetMapping("/")
    public String about(Model model) {
        model.addAttribute("user", userService.get(1));
        return "about";
    }
}