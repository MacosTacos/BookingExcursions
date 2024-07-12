package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class ClientEntity extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private List<BookingEntity> bookingEntityList;

    public ClientEntity(String name, String surname, String email, String phoneNumber, List<BookingEntity> bookingEntityList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookingEntityList = bookingEntityList;
    }

    protected ClientEntity() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "clientEntity")
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }
}
