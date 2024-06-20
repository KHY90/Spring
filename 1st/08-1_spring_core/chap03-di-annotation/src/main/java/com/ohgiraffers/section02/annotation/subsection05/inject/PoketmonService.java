package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service("pokemonServiceInject")
public class PoketmonService {

    // 1. 필드 주입 방식
    //@Inject
    //@Qualifier("charmander")
    private Poketmon poketmon;

    @Inject
    public PoketmonService(Poketmon poketmon) {
        this.poketmon = poketmon;
    }

    public void poketmonAttack(){
        poketmon.attack();
    }
}
