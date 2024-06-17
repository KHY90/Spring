package com.ohgiraffers.spurscoder;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class PracticeController {

//    @GetMapping("/mission1")
//    public ModelAndView mission1(ModelAndView mv, @RequestParam(name = "pathValue", required = false) String value) {
//        if (value != null) {
//            mv.addObject("message", value);
//        }
//        mv.setViewName("mission1");
//        return mv;
//    }

    @GetMapping("/mission1")
    public ModelAndView mission1(ModelAndView mv, @RequestParam("pathValue") String value) {
        mv.addObject("message", value);
        mv.setViewName("mission1");
        return mv;
    }
}
