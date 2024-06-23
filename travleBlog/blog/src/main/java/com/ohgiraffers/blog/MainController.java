package com.ohgiraffers.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(ModelAndView mv) {

        return "index";
    }

    @GetMapping("/plan")
    public String plan(ModelAndView mv) {

        return "plan/plan";
    }

    @GetMapping("/share")
    public String share(ModelAndView mv) {

        return "share/share";
    }

    @GetMapping("/login")
    public String login(ModelAndView mv) {

        return "login/login";
    }

}
