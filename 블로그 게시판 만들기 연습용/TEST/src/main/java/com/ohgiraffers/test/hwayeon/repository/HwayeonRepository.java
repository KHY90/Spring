package com.ohgiraffers.test.hwayeon.repository;

import com.ohgiraffers.test.hwayeon.model.entity.HwayeonBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HwayeonRepository extends JpaRepository<HwayeonBlog, Integer> {

//    void deleteById(Integer blogNo);

    List<HwayeonBlog> findTopNByOrderByCreateDateDesc(int count);

}