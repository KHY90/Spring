package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class MenuAndCategory {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @JoinColumn(name = "category_code")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @Column(name = "orderable_status")
    private String orderableStatus;

}
