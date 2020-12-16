package sd.app.contrillers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sd.app.model.Project;
import sd.app.model.User;
import sd.app.sevices.UserService;

import java.security.Principal;
import java.util.Optional;

/**
 * @author Sergey Inyakin
 */

@Controller
@AllArgsConstructor
@RequestMapping(value = "/")
public class MainController {

    private final UserService userService;

    @GetMapping
    public String about(Model model, Principal principal) {

        if (principal == null) return "redirect:/login";

        Optional<User> userOptional = userService.findByUsername(principal.getName());
        userOptional.ifPresent(user -> {
            model.addAttribute("user", user);
            model.addAttribute("project", new Project());
        });

        return "index";
    }

    @PostMapping("/profile")
    public String aboutSave(
            @ModelAttribute User user,
            Principal principal){

        if (principal == null) return "redirect:/login";

        Optional<User> userOptional = userService.findByUsername(principal.getName());
        userOptional.ifPresent(userOld -> {
            if (user.getAbout() != null) userOld.setAbout(user.getAbout());
            if (user.getBirthday() != null) userOld.setBirthday(user.getBirthday());
            if (user.getPhone() != null) userOld.setPhone(user.getPhone());
            if (user.getEmail() != null) userOld.setEmail(user.getEmail());
            if (user.getWebsite() != null) userOld.setWebsite(user.getWebsite());
            userService.save(userOld);
        });

    return "redirect:/";
    }
}