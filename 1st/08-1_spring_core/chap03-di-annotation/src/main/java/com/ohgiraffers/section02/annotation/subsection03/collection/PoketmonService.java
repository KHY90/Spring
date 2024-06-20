package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PoketmonService {

//    private List<Poketmon> poketmonList;

//    public PoketmonService(List<Poketmon> poketmonList) {
//        this.poketmonList = poketmonList;
//    }

//    public void poketmonAttack(){
//        poketmonList.forEach(Poketmon::attack);
//    }

    private Map<String, Poketmon> poketmonMap;

    @Autowired
    public PoketmonService(Map<String, Poketmon> poketmonMap) {
        this.poketmonMap = poketmonMap;
    }

    public void poketmonAttack(){
        poketmonMap.forEach((k,v)->{
            System.out.println("key : " + k);
            System.out.println("value : ");
            v.attack();
        });
    }

}
