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

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private Institution institution;

    public MenuCategory() {
    }

    public MenuCategory(Long id, String name, Institution institution) {
        this.id = id;
        this.name = name;
        this.institution = institution;
    }

    public MenuCategory(String name, Institution institution) {
        this.name = name;
        this.institution = institution;
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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", institution=" + institution +
                '}';
    }
}
