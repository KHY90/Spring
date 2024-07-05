package com.ohgiraffers.test.hwayeon.repository;

import com.ohgiraffers.test.hwayeon.model.entity.HwayeonBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HwayeonRepository extends JpaRepository<HwayeonBlog, Integer> {

    @Query("SELECT h FROM HwayeonBlog h ORDER BY h.createDate DESC")
    List<HwayeonBlog> findTop5ByOrderByCreateDateDesc();

}