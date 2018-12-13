package com.majesthink.adik.kemendikbud.model;

public class Pelajaran {
    private String name, PELAJARAN_ICON;
    private int id, total;

    public Pelajaran(){

    }

    public Pelajaran(int id, String name, String PELAJARAN_ICON, int total){
        this.id = id;
        this.name = name;
        this.PELAJARAN_ICON = PELAJARAN_ICON;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCATEGORIES_ICON() {
        return PELAJARAN_ICON;
    }

    public void setCATEGORIES_ICOM(String CATEGORIES_ICON) {
        this.PELAJARAN_ICON = CATEGORIES_ICON;
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
