package com.ohgiraffers.chap07thymeleaf.controller;

import com.ohgiraffers.chap07thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.chap07thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lecture")
public class LectureController {

//    @RequestMapping(value="expression", method = RequestMethod.GET)
//    public ModelAndView expression(ModelAndView mv) {
//        return mv;
//    }
//  위 아래 같은 의미
    @GetMapping("expression") // get 방식으로 요청이 들어올때
    public ModelAndView expression(ModelAndView mv) {
        mv.addObject("member", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        mv.addObject("hello", "hello!<h3>Thymeleaf</h3>");
        mv.setViewName("lecture/expression");
        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {
        mv.addObject("num", 1);
        mv.addObject("str", "사과");
        List<MemberDTO> memberDTOList = new ArrayList<>();
        memberDTOList.add(new MemberDTO("홍길동", 20, '남', "서초구"));
        memberDTOList.add(new MemberDTO("콩국수", 21, '여', "강남구"));
        memberDTOList.add(new MemberDTO("쌀국수", 22, '남', "안산"));
        memberDTOList.add(new MemberDTO("비빔국수", 19, '여', "의정부"));
        memberDTOList.add(new MemberDTO("물냉면", 23, '남', "인천"));
        mv.addObject("memberList", memberDTOList);
        mv.setViewName("/lecture/conditional");
        return mv;
    }


    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv) {
        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 3);
        mv.addObject("selectCriteria", selectCriteria);
        MemberDTO member = new MemberDTO("홍길동", 20, '남', "서울시 서초구");
        mv.addObject("member", member);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberList.add(new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberList.add(new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 성북구"));
        mv.addObject("memberList", memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberMap.put("m02", new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberMap.put("m03", new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberMap.put("m04", new MemberDTO("신사임당", 30, '여', "서울시 성북구"));
        mv.addObject("memberMap", memberMap);

        return mv;
    }

    @GetMapping("/fragment")
    public ModelAndView fragment(ModelAndView mv) {
        mv.addObject("test1", "values1");
        mv.addObject("test2", "values2");
        mv.setViewName("/lecture/fragment");

        return mv;
    }


}
