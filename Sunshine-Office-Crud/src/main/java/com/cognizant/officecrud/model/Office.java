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
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column (columnDefinition="tinyint(1) default 1")
    private boolean active = true;
    @Column(nullable = false)
    private Long managerId;

    /*
    Optional
     */
    private String zip;
    private String website;
    private String fax;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                Objects.equals(getState(), office.getState()) &&
                Objects.equals(getZip(), office.getZip()) &&
                Objects.equals(getCountry(), office.getCountry()) &&
                Objects.equals(getManagerId(), office.getManagerId()) &&
                Objects.equals(getWebsite(), office.getWebsite()) &&
                Objects.equals(getFax(), office.getFax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOfficeId(), getOfficeName(), getStreetAddress(), getCity(), getState(), getZip(), getCountry(), isActive(), getManagerId(), getWebsite(), getFax());
    }
}
