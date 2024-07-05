package com.ohgiraffers.test.hwayeon.controller;

import com.ohgiraffers.test.hwayeon.model.dto.HwayeonBlogDTO;
import com.ohgiraffers.test.hwayeon.service.HwayeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hwayeon")
public class HwayeonController {

    private final HwayeonService hwayeonService;

    @Autowired
    public HwayeonController(HwayeonService hwayeonService) {
        this.hwayeonService = hwayeonService;
    }

    // 메인 페이지
    @GetMapping("/main")
    public ModelAndView mainPage() {
        List<HwayeonBlogDTO> recentPosts = hwayeonService.getRecentPosts();
        ModelAndView mv = new ModelAndView("/hwayeon/main");
        mv.addObject("posts", recentPosts);
        return mv;
    }

    // 등록 페이지 불러오기
    @GetMapping("/editpage")
    public ModelAndView editPage() {
        ModelAndView mv = new ModelAndView("/hwayeon/editpage");
        mv.addObject("blogDTO", new HwayeonBlogDTO());

        return mv;
    }

    // 등록할 내용 저장하기
    @PostMapping("/postpage")
    public String createPost(@ModelAttribute("blogDTO") HwayeonBlogDTO blogDTO) {
        hwayeonService.createPost(blogDTO);

        return "redirect:/hwayeon/main";
    }

    // 수정을 위해 불러오기
    @GetMapping("/modifypage/{blogNo}")
    public String modifyPage(@PathVariable Integer blogNo, Model model) {
        HwayeonBlogDTO blogDTO = hwayeonService.getPostById(blogNo);
        model.addAttribute("blogDTO", blogDTO);

        return "/hwayeon/modifypage";
    }

    // 수정 후 적용
    @PostMapping("/modifypage")
    public String updatePost(@ModelAttribute("blogDTO") HwayeonBlogDTO blogDTO) {
        hwayeonService.updatePost(blogDTO);
        return "redirect:/hwayeon/main";
    }

    // 삭제
    @GetMapping("/delete/{blogNo}")
    public String deletePost(@PathVariable Integer blogNo) {
        hwayeonService.deletePost(blogNo);
        return "redirect:/hwayeon/main";
    }
}

