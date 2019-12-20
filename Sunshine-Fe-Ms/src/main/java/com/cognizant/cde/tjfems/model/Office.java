package com.cognizant.cde.tjfems.model;

import java.io.Serializable;
import java.util.Objects;

public class Office implements Serializable {
    private Long officeId;
    private String officeName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Boolean active;

    public Office() { }

    public Office(String officeName, String streetAddress, String city, String state, String zip, String country) {
        this.officeName = officeName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.setActive(true);
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(getOfficeId(), office.getOfficeId()) &&
                Objects.equals(getOfficeName(), office.getOfficeName()) &&
                Objects.equals(getStreetAddress(), office.getStreetAddress()) &&
                Objects.equals(getCity(), office.getCity()) &&
                Objects.equals(getState(), office.getState()) &&
                Objects.equals(getZip(), office.getZip()) &&
                Objects.equals(getCountry(), office.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOfficeId(), getOfficeName(), getStreetAddress(), getCity(), getState(), getZip(), getCountry(), getActive());
    }
}
