package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guides")
public class GuideEntity {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private List<ExcursionEntity> excursionEntityList;

    public GuideEntity(Long id, String name, String surname, String phoneNumber, List<ExcursionEntity> excursionEntityList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.excursionEntityList = excursionEntityList;
    }

    public GuideEntity() {
    }

    @Id
    @SequenceGenerator(
            name = "guide_sequence",
            sequenceName = "guide_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guide_sequence"
    )
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "guideEntity", targetEntity = ExcursionEntity.class)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
