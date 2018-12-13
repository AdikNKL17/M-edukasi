package com.majesthink.adik.kemendikbud.model;

public class Categories {
    private String name, CATEGORIES_ICON;
    private int id, total;

    public Categories(){

    }

    public Categories(int id, String name, String CATEGORIES_ICON, int total){
        this.id = id;
        this.name = name;
        this.CATEGORIES_ICON = CATEGORIES_ICON;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCATEGORIES_ICON() {
        return CATEGORIES_ICON;
    }

    public void setCATEGORIES_ICOM(String CATEGORIES_ICON) {
        this.CATEGORIES_ICON = CATEGORIES_ICON;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
