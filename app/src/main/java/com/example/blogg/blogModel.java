package com.example.blogg;

public class blogModel {

    String id;
    String title;
    String categ;
    String categ1;
    String image;
    String avatar;
    String description;
    String name;
    String prof;

    public blogModel(String id, String title, String image,String categ,String categ1,String avatar,String name,String description,String prof) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.categ = categ;
        this.categ1 = categ1;
        this.avatar = avatar;
        this.name = name;
        this.description = description;
        this.prof = prof;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public blogModel() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCateg() {
        return categ;
    }

    public String getCateg1() {
        return categ1;
    }

    public void setCateg1(String categ1) {
        this.categ1 = categ1;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }
}
