package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "administrators")
public class AdministratorEntity {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private List<BookingEntity> bookingEntityList;

    public AdministratorEntity(Long id, String name, String surname, String phoneNumber, List<BookingEntity> bookingEntityList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bookingEntityList = bookingEntityList;
    }

    public AdministratorEntity() {
    }

    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
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

    @OneToMany(mappedBy = "administratorEntity", fetch = FetchType.LAZY, cascade = CascadeType.DETACH, targetEntity = BookingEntity.class)
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }
}
