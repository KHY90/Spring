package com.ohgiraffers.springboottest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class MessageController {

    @GetMapping("/{message}")
    public String selectOrderDetail(Model model, @PathVariable("message") String message) {
        model.addAttribute("message", message);
        return "result";
    }
}
