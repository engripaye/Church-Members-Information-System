package dev.engripaye.churchmembersinformationsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String contact;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String suggestion;

    @Column(name = "prayer_point", columnDefinition = "TEXT")
    private String prayerPoint;

    public Member(){

    }

    public Member(Long id, String name, String sex, String contact, LocalDateTime dateOfBirth, String address, String suggestion, String prayerPoint) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.contact = contact;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.suggestion = suggestion;
        this.prayerPoint = prayerPoint;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getPrayerPoint() {
        return prayerPoint;
    }

    public void setPrayerPoint(String prayerPoint) {
        this.prayerPoint = prayerPoint;
    }
}
