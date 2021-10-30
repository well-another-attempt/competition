package com.slowpoker.competition.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="image_url", nullable = false)
    private String imageUrl;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="price", nullable = false)
    private Integer price;

    @OneToOne
    @JoinColumn(name="menu_category_id", referencedColumnName = "id")
    private MenuCategory menuCategory;

    @ManyToMany(mappedBy = "foods")
    private Set<Order> orders;

    public Food() {

    }

    public Food(String name, String imageUrl, String description, Integer price, MenuCategory menuCategory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public Food(Long id, String name, String imageUrl, String description, Integer price, MenuCategory menuCategory, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.menuCategory = menuCategory;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", menuCategory=" + menuCategory +
                ", orders=" + orders +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
