package com.example.studyjpa.entity;

import com.example.studyjpa.entity.Item.Item;
import jakarta.persistence.*;

@Entity
public class CategoryItem extends BaseColumn {
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ITEM_ID")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    //연관관계 편의 메소드
    public void setCategory(Category category) {
        this.category = category;
        category.getCategoryItems().add(this);
    }

    //연관관계 편의 메소드
    public void setItem(Item item) {
        this.item = item;
        item.getCategoryItems().add(this);
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Item getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryId(Category category) {
        this.category = category;
    }

    public void setItemId(Item item) {
        this.item = item;
    }


}
