package com.majesthink.adik.kemendikbud.model;

public class Jenjang {

    private int id, total;
    private String name, JELAJAH_ICON;

    public Jenjang(){

    }

    public Jenjang(int id, String name, String JELAJAH_ICON, int total) {
        this.id = id;
        this.total = total;
        this.name = name;
        this.JELAJAH_ICON = JELAJAH_ICON;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJELAJAH_ICON() {
        return JELAJAH_ICON;
    }

    public void setJELAJAH_ICON(String JELAJAH_ICON) {
        this.JELAJAH_ICON = JELAJAH_ICON;
    }
}
