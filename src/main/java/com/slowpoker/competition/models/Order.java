package com.slowpoker.competition.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="order_number", nullable = false, unique = true)
    private String orderNumber;

    @Column(name="order_sum", nullable = false)
    private Integer orderSum;

    @Column(name="client_phone_number")
    private String clientPhoneNumber;

    @Column(name="client_name")
    private String clientName;

    @OneToOne
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name="Order_Food", joinColumns = {@JoinColumn(name="order_id")}, inverseJoinColumns = {@JoinColumn(name = "food_id")})
    private Set<Food> foods;


    public Order() {
    }

    public Order(String orderNumber, Integer orderSum, String clientPhoneNumber, String clientName, Company company, Set<Food> foods) {
        this.orderNumber = orderNumber;
        this.orderSum = orderSum;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientName = clientName;
        this.company = company;
        this.foods = foods;
    }

    public Order(Long id, String orderNumber, Integer orderSum, String clientPhoneNumber, String clientName) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderSum = orderSum;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientName = clientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}

