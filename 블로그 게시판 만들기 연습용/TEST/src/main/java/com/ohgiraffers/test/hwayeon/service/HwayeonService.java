package com.ohgiraffers.test.hwayeon.service;

import com.ohgiraffers.test.hwayeon.model.dto.HwayeonBlogDTO;
import com.ohgiraffers.test.hwayeon.model.entity.HwayeonBlog;
import com.ohgiraffers.test.hwayeon.repository.HwayeonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HwayeonService {

    private final HwayeonRepository hwayeonRepository;

    @Autowired
    public HwayeonService(HwayeonRepository hwayeonRepository) {
        this.hwayeonRepository = hwayeonRepository;
    }

    @Transactional(readOnly = true)
    public List<HwayeonBlogDTO> getAllPosts() {
        List<HwayeonBlog> blogs = hwayeonRepository.findAll();
        return blogs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<HwayeonBlogDTO> getRecentPosts() {
        List<HwayeonBlog> blogs = hwayeonRepository.findAll();
        return blogs.stream()
                .sorted((b1, b2) -> b2.getCreateDate().compareTo(b1.getCreateDate())) // 최신순 정렬
                .limit(5) // 최근 5개
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public HwayeonBlogDTO createPost(HwayeonBlogDTO blogDTO) {
        HwayeonBlog blog = new HwayeonBlog();
        BeanUtils.copyProperties(blogDTO, blog);
        blog.setCreateDate(new Date());
        HwayeonBlog savedBlog = hwayeonRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    @Transactional
    public HwayeonBlogDTO updatePost(HwayeonBlogDTO blogDTO) {
        Optional<HwayeonBlog> optionalBlog = hwayeonRepository.findById(blogDTO.getBlogNo());
        if (optionalBlog.isPresent()) {
            HwayeonBlog blog = optionalBlog.get();
            BeanUtils.copyProperties(blogDTO, blog);
            blog.setCreateDate(new Date()); // 수정 시간 업데이트
            HwayeonBlog updatedBlog = hwayeonRepository.save(blog);
            return convertToDTO(updatedBlog);
        }
        throw new IllegalArgumentException("Blog with id " + blogDTO.getBlogNo() + " not found");
    }

    @Transactional
    public void deletePost(Integer blogNo) {
        hwayeonRepository.deleteById(blogNo);
    }

    @Transactional(readOnly = true)
    public HwayeonBlogDTO getPostById(Integer blogNo) {
        Optional<HwayeonBlog> optionalBlog = hwayeonRepository.findById(blogNo);
        return optionalBlog.map(this::convertToDTO)
                .orElse(null);
    }

    private HwayeonBlogDTO convertToDTO(HwayeonBlog blog) {
        HwayeonBlogDTO dto = new HwayeonBlogDTO();
        BeanUtils.copyProperties(blog, dto);
        return dto;
    }
}
