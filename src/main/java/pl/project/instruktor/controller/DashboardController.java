package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class DashboardController {

    @RequestMapping("")
    public String home(){
        return "panel";
    }
}
