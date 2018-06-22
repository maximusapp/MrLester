package com.lister.mrlister.mrlester.data;


public class ItemsNewProduct {

    public int id;
    public String name;
    public int items_id;
    public int checked;

    public ItemsNewProduct(int id, String name, int items_id, int checked) {
        this.id = id;
        this.name = name;
        this.items_id = items_id;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public int getItems_id() {
        return items_id;
    }
}
