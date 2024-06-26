package com.ohgiraffers.section01.problem;

public class Menu {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private String orderableStatus;
    private int CategoryCode;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, String orderableStatus, int categoryCode) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.orderableStatus = orderableStatus;
        CategoryCode = categoryCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public int getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        CategoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", orderableStatus='" + orderableStatus + '\'' +
                ", CategoryCode=" + CategoryCode +
                '}';
    }
}

