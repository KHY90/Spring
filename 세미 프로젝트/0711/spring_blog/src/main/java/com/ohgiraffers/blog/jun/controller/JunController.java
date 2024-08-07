package com.ohgiraffers.blog.jun.controller;

import com.ohgiraffers.blog.jun.model.dto.BlogDTO;
import com.ohgiraffers.blog.jun.model.entity.JunBlog;
import com.ohgiraffers.blog.jun.service.JunService;
import com.ohgiraffers.blog.jun.service.JunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jun")
public class JunController {

    private final JunService junService;
    private BlogDTO currentBlog;

    @Autowired
    public JunController(JunService junService) {
        this.junService = junService;
    }

    @GetMapping
    public String jun() {
        return "/jun/page";
    }


    @GetMapping("/junpost")
    public String postPage(Model model) {
        if (currentBlog != null) {
            model.addAttribute("blogTitle", currentBlog.getBlogTitle());
            model.addAttribute("blogContent", currentBlog.getBlogContent());
        }
        return "jun/junpost";
    }

    @GetMapping("/postpage/{id}")
    public String postPage(@PathVariable Long id, Model model) {
        BlogDTO blogDTO = junService.getBlogById(id);
        if (blogDTO != null) {
            model.addAttribute("blogTitle", blogDTO.getBlogTitle());
            model.addAttribute("blogContent", blogDTO.getBlogContent());
        }
        return "jun/postpage";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Long id, Model model) {
        BlogDTO blogDTO = junService.getBlogById(id);
        if (blogDTO == null) {
            return "redirect:/jun/junpost-list";
        }
        model.addAttribute("blogDTO", blogDTO);
        return "jun/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSubmit(@ModelAttribute BlogDTO blogDTO) {
        junService.updateBlog(blogDTO);
        return "redirect:/jun/junpost-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, Model model) {
        BlogDTO blogDTO = junService.getBlogById(id);
        if (blogDTO == null) {
            return "redirect:/jun/junpost-list";
        }
        model.addAttribute("blogDTO", blogDTO);
        return "jun/delete";
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirm(@PathVariable Long id) {
        junService.deleteBlogById(id);
        return "redirect:/jun/junpost-list";
    }

    @GetMapping("/jun")
    public String share(Model model) {
        List<BlogDTO> blogs = junService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "jun/junpost-list";
    }















    @PostMapping
    public ModelAndView postBlog(BlogDTO blogDTO, ModelAndView mv){

        if(blogDTO.getBlogTitle() == null || blogDTO.getBlogTitle().equals("")){
            mv.setViewName("redirect:/jun/post");
        }
        if(blogDTO.getBlogContent() == null || blogDTO.getBlogContent().equals("")){
            mv.setViewName("redirect:jun/post");
        }

        int result = junService.post(blogDTO);

        if(result <= 0){
            mv.setViewName("error/page");
        }else{
            currentBlog = blogDTO;
            mv.setViewName("redirect:/jun/junpost");
        }
        return mv;
    }

    @GetMapping("/review")
    public String share() {
        return "/review";
    }


}


// 메인화면 -> 글 작성 페이지 -> 작성된 글 표시   // 글 목록 화면 연결 안됨
//
//
//
//메인화면
//->글 목록 화면
//-홈 버튼 추가
//- 게시물 목록에서 게시물 등록, 수정, 삭제 기능
//-등록
//-> 글 작성 페이지
//
//
//root계정으로
//
//mysql 설정할때 root
//
//
//    url: jdbc:mysql://localhost:3306/gangnam
//    username: gangnam
//    password: gangnam
//    driver-class-name: com.mysql.cj.jdbc.Driver
//
//위에 세개만 그대로

