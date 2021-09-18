package pl.finalproject.accessingdatamysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String Home() {
        return "home";
    }

    @GetMapping("/aboutProject")
    public String aboutProject() {
        return "aboutProject";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "createUser";
    }

}
