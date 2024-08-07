package com.ohgiraffers.chap02securityjwt.user.repository;

import com.ohgiraffers.chap02securityjwt.user.model.entity.OhUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<OhUser, Long> {



}
