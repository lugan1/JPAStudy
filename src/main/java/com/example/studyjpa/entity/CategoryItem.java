package com.example.studyjpa.entity;

import com.example.studyjpa.entity.Item.Item;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@ToString
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

}
