package com.ohgiraffers.spurscoder;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @GetMapping("/form")
//    public String showForm() {
//        return "form";
//
//    }
//
//    @PostMapping("/mission1")
//    public String submitForm(@RequestParam("permissions") String permissions,
//                             @RequestParam("pathValue") String pathValue,
//                             Model model) {
//        if ("user".equals(permissions)) {
//            // 처리 로직 추가
//            // 예: 데이터베이스에 저장하거나 다른 서비스에 전송하는 등의 작업 수행
//            model.addAttribute("message", "권한이 유저인 경우의 처리 결과");
//        } else if ("admin".equals(permissions)) {
//            model.addAttribute("error", "잘못된 요청입니다.");
//        }
//        return "result";
//    }

}
