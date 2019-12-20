package com.cognizant.officecrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;
    @Column(nullable = false)
    private String officeName;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zip;
    @Column (columnDefinition="tinyint(1) default 1")
    private boolean active = true;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return isActive() == office.isActive() &&
                Objects.equals(getOfficeId(), office.getOfficeId()) &&
                Objects.equals(getOfficeName(), office.getOfficeName()) &&
                Objects.equals(getStreetAddress(), office.getStreetAddress()) &&
                Objects.equals(getCity(), office.getCity()) &&
                Objects.equals(getZip(), office.getZip());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOfficeId(), getOfficeName(), getStreetAddress(), getCity(), getZip(), isActive());
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", active=" + active +
                '}';
    }
}
