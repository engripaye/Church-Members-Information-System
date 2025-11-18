package dev.engripaye.churchmembersinformationsystem.dto;

import dev.engripaye.churchmembersinformationsystem.model.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MemberRequest {

    private String name;
    private String sex;
    private String contact;
    private String dateOfBirth; // format: yyyy-MM-dd
    private String address;
    private String occupation;
    private String suggestion;
    private String prayerPoint;

    public MemberRequest(){

    }

    public MemberRequest(String name, String sex, String contact, String dateOfBirth, String address, String occupation, String suggestion, String prayerPoint) {
        this.name = name;
        this.sex = sex;
        this.contact = contact;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.occupation = occupation;
        this.suggestion = suggestion;
        this.prayerPoint = prayerPoint;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public Member toEntity(){


        // parse the date(String -> localDate)
        LocalDateTime dobLocalDate = LocalDate.parse(this.dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();

        // convert to LocalDate(00:00 time)
        LocalDateTime dobDateTime = dobLocalDate.toLocalDate().atStartOfDay();

        // calculate age
        int calculatedAge = Period.between(LocalDate.from(dobDateTime), LocalDate.now()).getYears();

        return new Member(
                null,
                this.name,
                this.sex,
                this.contact,
                this.

        )
    }
}
