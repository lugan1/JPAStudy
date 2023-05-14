package com.example.studyjpa.entity.Item;

import com.example.studyjpa.entity.CategoryItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;

    public Item() {
    }

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    //연관관계 편의 메소드
    public void addCategoryItem(CategoryItem categoryItem) {
        this.categoryItems.add(categoryItem);
        categoryItem.setItem(this);
    }

    //연관관계 편의 메소드
    public void removeCategoryItem(CategoryItem categoryItem) {
        this.categoryItems.remove(categoryItem);
        categoryItem.setItem(null);
    }

    //연관관계 편의 메소드
    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }

    //연관관계 편의 메소드
    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    //연관관계 편의 메소드
    public void setName(String name) {
        this.name = name;
    }

    //연관관계 편의 메소드
    public void setPrice(int price) {
        this.price = price;
    }
}
