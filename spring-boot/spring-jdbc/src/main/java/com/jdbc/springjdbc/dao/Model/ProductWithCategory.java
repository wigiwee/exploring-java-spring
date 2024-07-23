package com.jdbc.springjdbc.dao.Model;

public class ProductWithCategory {

    private int id;
    private String title;
    private String description;
    private int price;
    private String catTitle;

    public ProductWithCategory(int id, String title, String description, int price, String catTitle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.catTitle = catTitle;
    }

    public ProductWithCategory() {
    }

    @Override
    public String toString() {
        return "ProductWithCategory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", catTitle=" + catTitle +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }
}
