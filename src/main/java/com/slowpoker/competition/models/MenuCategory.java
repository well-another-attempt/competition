package com.slowpoker.competition.models;

import javax.persistence.*;

@Entity
@Table(name="MenuCategory")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public MenuCategory() {
    }


    public MenuCategory(String name, Company company) {
        this.name = name;
        this.company = company;
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

    public Company getInstitution() {
        return company;
    }

    public void setInstitution(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
