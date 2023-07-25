package pk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControler {
    @GetMapping("/welcome")
    public String getWelcomePage() {
        return "welcome";
    }


    @GetMapping("/accessdenied")
    public String getAccessDeniedPage() {
        return "accessdenied";
    }
}