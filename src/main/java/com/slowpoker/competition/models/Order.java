package com.slowpoker.competition.models;

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

    @Column(name="sum", nullable = false)
    private Integer sum;

    @Column(name="client_phone_number")
    private String clientPhoneNumber;

    @Column(name="client_name")
    private String clientName;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name="institution_id", referencedColumnName = "id")
    private Institution institution;

    @ManyToMany(cascade = { CascadeType.ALL })
//    @Size(min=1)
    @JoinTable(name="Order_Food", joinColumns = {@JoinColumn(name="order_id")}, inverseJoinColumns = {@JoinColumn(name = "food_id")})
    private Set<Food> foods;

    public Order() {
    }

    public Order(String orderNumber, Integer sum, String clientPhoneNumber, String clientName, Institution institution, Set<Food> foods) {
        this.orderNumber = orderNumber;
        this.sum = sum;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientName = clientName;
        this.institution = institution;
        this.foods = foods;
    }

    public Order(Long id, String orderNumber, Integer sum, String clientPhoneNumber, String clientName, Institution institution, Set<Food> foods) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.sum = sum;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientName = clientName;
        this.institution = institution;
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", sum=" + sum +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", clientName='" + clientName + '\'' +
                ", institution=" + institution +
                ", foods=" + foods +
                '}';
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}

