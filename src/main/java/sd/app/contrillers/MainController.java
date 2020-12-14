package sd.app.contrillers;

import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sd.app.model.User;
import sd.app.sevices.UserService;

import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String about(Model model) {
        Optional<User> userOptional = userService.get(1);
        userOptional.ifPresent(user -> model.addAttribute("user", user));
        return "index";
    }
}