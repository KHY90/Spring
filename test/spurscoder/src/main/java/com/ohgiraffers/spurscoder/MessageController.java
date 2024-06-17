package com.ohgiraffers.spurscoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*") // 클래스 레벨에서의 기본 URL 패턴 설정
public class MessageController {

    @GetMapping("/result") // HTTP GET 요청을 처리하는 핸들러 메서드
    public ModelAndView result(ModelAndView mv, @RequestParam("pathValue") String value) {
        mv.addObject("pathValue", value); // ModelAndView 객체에 "pathValue" 속성을 추가
        mv.setViewName("result"); // 사용할 뷰의 이름을 "result"로 설정
        return mv; // ModelAndView 객체 반환하여 해당 뷰로 데이터 전달
    }
}
