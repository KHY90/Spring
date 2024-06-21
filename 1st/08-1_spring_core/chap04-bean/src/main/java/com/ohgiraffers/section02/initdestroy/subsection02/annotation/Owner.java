package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @PostConstruct
    public void openShop(){
        System.out.println("가게가 열렸다. 이제 쇼핑을 하라.");
    }

    @PreDestroy
    public void closeShop(){
        System.out.println("문 닫음. 다 나가셈");
    }

}
