package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "administrators")
public class AdministratorEntity extends BaseEntity {
    private String name;
    private String surname;
    private String phoneNumber;
    private List<BookingEntity> bookingEntityList;
    private List<ExcursionEntity> excursionEntityList;

    public AdministratorEntity(String name, String surname, String phoneNumber, List<BookingEntity> bookingEntityList) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bookingEntityList = bookingEntityList;
    }

    protected AdministratorEntity() {
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

    @OneToMany(mappedBy = "administratorEntity", fetch = FetchType.LAZY, cascade = CascadeType.DETACH, targetEntity = BookingEntity.class)
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }

    @OneToMany(mappedBy = "administratorEntity", fetch = FetchType.LAZY, cascade = CascadeType.DETACH, targetEntity = ExcursionEntity.class)
    public List<ExcursionEntity> getExcursionEntityList() {
        return excursionEntityList;
    }

    public void setExcursionEntityList(List<ExcursionEntity> excursionEntityList) {
        this.excursionEntityList = excursionEntityList;
    }
}
