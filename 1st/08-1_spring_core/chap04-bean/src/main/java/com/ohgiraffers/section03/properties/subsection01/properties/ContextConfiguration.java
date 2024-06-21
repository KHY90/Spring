package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Date;

@Configuration
// resources 하위의 경로로 기술한다.
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name:팥붕어빵}")
    private String carpBreadName;

    @Value("${bread.carpbread.price:0}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name:걍우유}")
    private String milkName;

    @Value("${beverage.milk.price:0}")
    private int milkPrice;

    @Value("${beverage.milk.capacity:0}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name:걍물}") String waterName,
                         @Value("${beverage.water.price:0}") int waterPrice,
                         @Value("${beverage.water.capacity:0}") int waterCapacity){
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

}
