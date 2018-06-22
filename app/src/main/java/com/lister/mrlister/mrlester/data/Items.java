package com.lister.mrlister.mrlester.data;


public class Items {

    public int id;
    public String title;
    public String name;
    public String count;
    public int color;
    public int icon;


    public Items(int id, String title, int color, int icon) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.color = color;
        this.icon = icon;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}