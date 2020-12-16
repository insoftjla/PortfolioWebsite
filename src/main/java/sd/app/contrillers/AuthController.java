package sd.app.contrillers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sergey Inyakin
 */

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
