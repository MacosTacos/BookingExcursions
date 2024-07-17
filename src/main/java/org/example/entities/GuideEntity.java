package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guides")
public class GuideEntity extends BaseEntity {
    private String name;
    private String surname;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private GuideStatus guideStatus;
    private List<ExcursionEntity> excursionEntityList;

    public GuideEntity(String name, String surname, String phoneNumber, List<ExcursionEntity> excursionEntityList) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.excursionEntityList = excursionEntityList;
    }

    protected GuideEntity() {
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

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public GuideStatus getGuideStatus() {
        return guideStatus;
    }

    public void setGuideStatus(GuideStatus guideStatus) {
        this.guideStatus = guideStatus;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "guideEntity", targetEntity = ExcursionEntity.class)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
